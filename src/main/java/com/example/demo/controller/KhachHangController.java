package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.KhachHangService;
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
public class KhachHangController {
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/khach-hang/hien-thi")
    public String hienthi(Model model, @RequestParam(name = "p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<KhachHang> page = khachHangRepository.findAll(pageable);
        model.addAttribute("kh", page);
        model.addAttribute("p", page.getTotalElements());
        return "khachhang/KhachHang";
    }

    @PostMapping("/khach-hang/add")
    public String nhanVienAdd(@RequestParam("ma") String ma,
                              @RequestParam("ten") String ten,
                              @RequestParam("ho") String ho,
                              @RequestParam("tenDem") String tenDem,
                              @RequestParam("ngaySinh") String ngaySinh,
                              @RequestParam("sdt") String sdt,
                              @RequestParam("diaChi") String diaChi,
                              @RequestParam("thanhPho") String thanhPho,
                              @RequestParam("quocGia") String quocGia,
                              @RequestParam("matKhau") String matKhau
    ) {
        KhachHang ds = KhachHang.builder()
                .ma(ma)
                .ten(ten)
                .ho(ho)
                .tenDem(tenDem)
                .ngaySinh(ngaySinh)
                .sdt(sdt)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .matKhau(matKhau)
                .quocGia(quocGia)
                .build();
        khachHangService.add(ds);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/khach-hang/detail/{id}")
    public String detail(@PathVariable("id") UUID ID, Model model) {
        KhachHang ds = khachHangService.detail(ID).get();
        model.addAttribute("khs", ds);
        return "khachhang/KhachHang";
    }

    @GetMapping("/khach-hang/remover/{id}")
    public String update(@PathVariable("id") UUID ID, Model model) {
        khachHangService.delete(ID);
        return "redirect:/khach-hang/hien-thi";
    }

    @PostMapping("/khach-hang/update")
    public String nhanVienupdate(@RequestParam("ma") String ma,
                                 @RequestParam("ten") String ten,
                                 @RequestParam("ho") String ho,
                                 @RequestParam("tenDem") String tenDem,
                                 @RequestParam("ngaySinh") String ngaySinh,
                                 @RequestParam("sdt") String sdt,
                                 @RequestParam("diaChi") String diaChi,
                                 @RequestParam("thanhPho") String thanhPho,
                                 @RequestParam("quocGia") String quocGia,
                                 @RequestParam("matKhau") String matKhau,
                                 @RequestParam("id") UUID id
    ) {
        KhachHang ds = KhachHang.builder()
                .id(id)
                .ma(ma)
                .ten(ten)
                .ho(ho)
                .tenDem(tenDem)
                .ngaySinh(ngaySinh)
                .sdt(sdt)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .matKhau(matKhau)
                .quocGia(quocGia)
                .build();
        khachHangService.update(ds);
        return "redirect:/khach-hang/hien-thi";
    }
}
