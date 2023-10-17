package com.example.demo.controller;

import com.example.demo.entity.CuaHang;
import com.example.demo.repository.CuaHangRepository;
import com.example.demo.service.CuaHangService;
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
public class CuaHangController {
    @Autowired
    private CuaHangService cuaHangService;
    @Autowired
    private CuaHangRepository cuaHangRepository;

    @GetMapping("/cua-hang/hien-thi")
    public String hienthi(Model model, @RequestParam(name = "p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<CuaHang> ds = cuaHangRepository.findAll(pageable);
        model.addAttribute("ch", ds);
        model.addAttribute("p", ds.getTotalElements());
        return "cuahang/CuaHang";
    }

    @PostMapping("/cua-hang/add")
    public String cuaHangAdd(@RequestParam("ma") String ma,
                             @RequestParam("ten") String ten,
                             @RequestParam("diaChi") String diaChi,
                             @RequestParam("thanhPho") String thanhPho,
                             @RequestParam("quocGia") String quocGia , Model model
    ) {
        CuaHang ds = CuaHang.builder()
                .ma(ma)
                .ten(ten)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .quocGia(quocGia)
                .build();
        if(ma == "" || ten == "" || diaChi == "" || thanhPho == "" || quocGia == ""){
            model.addAttribute("thongBao" , "dữ liệu không được để trống !!");
            return "cuahang/CuaHang";
        }
        cuaHangService.add(ds);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("/cua-hang/remover/{id}")
    public String remover(@PathVariable("id") UUID id) {
        cuaHangService.delete(id);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("/cua-hang/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        CuaHang ds = cuaHangService.detail(id).get();
        model.addAttribute("chs", ds);
        return "cuahang/CuaHang";
    }

    @PostMapping("/cua-hang/update")
    public String cuaHangupdate(@RequestParam("ma") String ma,
                                @RequestParam("ten") String ten,
                                @RequestParam("diaChi") String diaChi,
                                @RequestParam("thanhPho") String thanhPho,
                                @RequestParam("quocGia") String quocGia,
                                @RequestParam("id") UUID id
    ) {
        CuaHang ds = CuaHang.builder()
                .id(id)
                .ma(ma)
                .ten(ten)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .quocGia(quocGia)
                .build();
        cuaHangService.update(ds);
        return "redirect:/cua-hang/hien-thi";
    }

}
