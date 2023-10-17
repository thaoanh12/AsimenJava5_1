package com.example.demo.controller;

import com.example.demo.entity.DongSP;
import com.example.demo.entity.MauSac;
import com.example.demo.repository.DongSpRepository;
import com.example.demo.service.DongSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

@Controller
public class DongSpController {
    @Autowired
    private DongSpRepository dongSpRepository;
    @Autowired
    private DongSpService dongSpService;

    @GetMapping("/dongsp/hien-thi")
    public String hienthi(Model model, @RequestParam(name = "p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<DongSP> page = dongSpRepository.findAll(pageable);
        model.addAttribute("nsx", page);
        model.addAttribute("p", page.getTotalElements());
        return "dongsp/DongSp";
    }

    @GetMapping("/dongsp/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("nsxs", dongSpService.detail(id).get());
        return "dongsp/DongSp";
    }

    @PostMapping("/dongsp/add")
    public String add(
            @RequestParam("ma") String ma,
            @RequestParam("ten") String ten
    ) {
        DongSP ds = DongSP.builder()
                .ma(ma)
                .ten(ten)
                .build();
        dongSpService.add(ds);
        return "redirect:/dongsp/hien-thi";
    }

    @PostMapping("/dongsp/update")
    public String update(
            @RequestParam("ma") String ma,
            @RequestParam("ten") String ten,
            @RequestParam("id") UUID id
    ) {
        DongSP ds = DongSP.builder()
                .id(id)
                .ma(ma)
                .ten(ten)
                .build();
        dongSpService.update(ds);
        return "redirect:/dongsp/hien-thi";
    }

    @GetMapping("/dongsp/remover/{id}")
    public String remover(@PathVariable("id") UUID id, Model model) {
        dongSpService.delete(id);
        return "redirect:/dongsp/hien-thi";
    }
}
