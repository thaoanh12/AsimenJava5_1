package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.ChucVuService;
import com.example.demo.service.CuaHangService;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class NhanVienController {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private NhanVienService nhanVienService ;
    @Autowired
    private CuaHangService cuaHangService ;
    @Autowired
    private ChucVuService chucVuService ;

    @GetMapping("/nhan-vien/hien-thi")
    public String nhanVienHienThi(Model model , @RequestParam("p")Optional<Integer> p){
        Pageable pageable = PageRequest.of(p.orElse(0) ,5);
        Page<NhanVien> ds = nhanVienRepository.findAll(pageable);
        model.addAttribute("nv" , ds );
        model.addAttribute("p" , ds.getTotalElements());
        model.addAttribute("cv" , chucVuService.getAll());
        model.addAttribute("ch" , cuaHangService.getAll());
        return "nhanvien/NhanVien";
    }
}
