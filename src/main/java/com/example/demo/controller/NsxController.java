package com.example.demo.controller;

import com.example.demo.entity.Nsx;
import com.example.demo.repository.NSXRepository;
import com.example.demo.service.NSXService;
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
public class NsxController {
    @Autowired
    private NSXRepository nsxRepository;
    @Autowired
    private NSXService nsxService;

    @GetMapping("/nsx-hien-thi")
    public String hienthi(Model model, @RequestParam(name = "p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Nsx> page = nsxRepository.findAll(pageable);
        model.addAttribute("nsx", page);
        model.addAttribute("p", page.getTotalElements());
        return "nsx/Nsx";
    }

    @GetMapping("/nsx-detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("nsxs", nsxService.detail(id).get());
        return "nsx/Nsx";
    }

    @PostMapping("/nsx-add")
    public String add(
            @RequestParam("ma") String ma,
            @RequestParam("ten") String ten
    ) {
        Nsx ds = Nsx.builder()
                .ma(ma)
                .ten(ten)
                .build();
        nsxService.add(ds);
        return "redirect:/nsx-hien-thi";
    }

    @PostMapping("/nsx-update")
    public String update(
            @RequestParam("ma") String ma,
            @RequestParam("ten") String ten,
            @RequestParam("id") UUID id
    ) {
        Nsx ds = Nsx.builder()
                .id(id)
                .ma(ma)
                .ten(ten)
                .build();
        nsxService.update(ds);
        return "redirect:/nsx-hien-thi";
    }

    @GetMapping("/nsx-remover/{id}")
    public String remover(@PathVariable("id") UUID id, Model model) {
        nsxService.delete(id);
        return "redirect:/nsx-hien-thi";
    }
}
