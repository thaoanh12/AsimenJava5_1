package com.example.demo.controller;

import com.example.demo.entity.Nsx;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.service.SanPhamService;
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
public class SanPhamController {
    @Autowired
    private SanPhamRepository sanPhamRepository ;
    @Autowired
    private SanPhamService sanPhamService ;

    @GetMapping("/san-pham/hien-thi")
    public String hienthi(Model model , @RequestParam(name = "p") Optional<Integer> p ){
        Pageable pageable = PageRequest.of(p.orElse(0) , 5);
        Page<SanPham> page = sanPhamRepository.findAll(pageable);
        model.addAttribute("nsx" , page);
        model.addAttribute("p" , page.getTotalElements());
        return "sanpham/SanPham";
    }
    @GetMapping("/san-pham/detail/{id}")
    public String detail(@PathVariable("id") UUID id , Model model){
        model.addAttribute("nsxs" , sanPhamService.detail(id).get());
        return"sanpham/SanPham";
    }
    @PostMapping("/san-pham/add")
    public String add(
            @RequestParam("ma") String ma ,
            @RequestParam("ten") String ten
    ){
        SanPham ds = SanPham.builder()
                .ma(ma)
                .ten(ten)
                .build();
        sanPhamService.add(ds);
        return "redirect:/san-pham/hien-thi";
    }
    @PostMapping("/san-pham/update")
    public String update(
            @RequestParam("ma") String ma ,
            @RequestParam("ten") String ten,
            @RequestParam("id") UUID id
    ){
        SanPham ds = SanPham.builder()
                .id(id)
                .ma(ma)
                .ten(ten)
                .build();
        sanPhamService.update(ds);
        return "redirect:/san-pham/hien-thi";
    }
    @GetMapping("/san-pham/remover/{id}")
    public String remover(@PathVariable("id") UUID id ,Model model){
        sanPhamService.delete(id);
        return"redirect:/san-pham/hien-thi";
    }
}
