package com.example.demo.controller;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.MauSacRepository;
import com.example.demo.service.MauSacService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

@Controller
public class MauSacController {
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private MauSacService mauSacService;

    @GetMapping("/mau-sac/hien-thi")
    public String hienthi(Model model, @RequestParam(name = "p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<MauSac> page = mauSacRepository.findAll(pageable);
        model.addAttribute("nsx", page);
        model.addAttribute("p", page.getTotalElements());
        return "mausac/MauSac";
    }

    @GetMapping("/mau-sac/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("nsxs", mauSacService.detail(id).get());
        return "mausac/MauSac";
    }

    @PostMapping("/mau-sac/add")
    public String add(
            @RequestParam("ma") String ma,
            @RequestParam("ten") String ten,
            Model model
    ) {
        MauSac ds = MauSac.builder()
                .ma(ma)
                .ten(ten)
                .build();

        if (ma == "" || ten == "") {
            model.addAttribute("thongBao", "dữ liệu không được để trống ");
            return "mausac/MauSac" ;
        }
        mauSacService.add(ds);
        return "redirect:/mau-sac/hien-thi";
    }

    @PostMapping("/mau-sac/update")
    public String update(
            @RequestParam("ma") String ma,
            @RequestParam("ten") String ten,
            @RequestParam("id") UUID id
    ) {
        MauSac ds = MauSac.builder()
                .id(id)
                .ma(ma)
                .ten(ten)
                .build();
        mauSacService.update(ds);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/mau-sac/remover/{id}")
    public String remover(@PathVariable("id") UUID id, Model model) {
        mauSacService.delete(id);
        return "redirect:/mau-sac/hien-thi";
    }
}
