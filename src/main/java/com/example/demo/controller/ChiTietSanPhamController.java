package com.example.demo.controller;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.DongSP;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.Nsx;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.ChiTietSanPhamRepository;
import com.example.demo.repository.MauSacRepository;
import com.example.demo.service.ChiTietSanPhamService;
import com.example.demo.service.DongSpService;
import com.example.demo.service.MauSacService;
import com.example.demo.service.NSXService;
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
public class ChiTietSanPhamController {
    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository ;
    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService ;
    @Autowired
    private MauSacService mauSacService ;
    @Autowired
    private SanPhamService sanPhamService ;
    @Autowired
    private DongSpService dongSpService ;
    @Autowired
    private NSXService nsxService ;

    @GetMapping("/chi-tiet-san-pham/hien-thi")
    public String hienthi(Model model , @RequestParam(name = "p")Optional<Integer> p){
        Pageable pageable = PageRequest.of(p.orElse(0) , 5);
        Page<ChiTietSanPham> ds = chiTietSanPhamRepository.findAll(pageable);
        model.addAttribute("ctsp" , ds);
        model.addAttribute("p" , ds.getTotalElements());
        model.addAttribute("sp" , sanPhamService.getAll());
        model.addAttribute("ms" , mauSacService.getAll());
        model.addAttribute("dsp" , dongSpService.getAll());
        model.addAttribute("nsx" , nsxService.getAll());
        return "chitietsanpham/ChiTietSanPham";
    }
    @GetMapping("/chi-tiet-san-pham/remover/{id}")
    public String delete(@PathVariable("id")UUID id){
        chiTietSanPhamService.delete(id);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }
    @GetMapping("/chi-tiet-san-pham/detail/{id}")
    public String detail(@PathVariable("id") UUID id , Model model){
        model.addAttribute("sp" , sanPhamService.getAll());
        model.addAttribute("ms" , mauSacService.getAll());
        model.addAttribute("dsp" , dongSpService.getAll());
        model.addAttribute("nsx" , nsxService.getAll());
        model.addAttribute("ctsps" , chiTietSanPhamService.detail(id).get());
        return "chitietsanpham/ChiTietSanPham";
    }
    @PostMapping("/chi-tiet-san-pham/add")
    public String add(
            @RequestParam("namBh") int namBh ,
            @RequestParam("soLuongTon") int soLuongTon ,
            @RequestParam("giaNhap") Float giaNhap ,
            @RequestParam("giaBan") Float giaBan ,
            @RequestParam("moTa") String moTa ,
            @RequestParam("idSp") UUID idSp ,
            @RequestParam("idDsp") UUID idDsp ,
            @RequestParam("idMauSac") UUID idMauSac ,
            @RequestParam("idNsx") UUID idNsx
//            @RequestParam("id") UUID id

    ){
        SanPham sp  = sanPhamService.detail(idSp).get();
        DongSP dsp  = dongSpService.detail(idDsp).get();
        MauSac ms = mauSacService.detail(idMauSac).get();
        Nsx nsx = nsxService.detail(idNsx).get();

        ChiTietSanPham ds = ChiTietSanPham.builder()
                .namBh(namBh)
                .soLuongTon(soLuongTon)
                .giaNhap(giaNhap)
                .giaBan(giaBan)
                .moTa(moTa)
                .idSp(sp)
                .idMauSac(ms)
                .idNsx(nsx)
                .idDongSp(dsp)
                .build();
        chiTietSanPhamService.add(ds);

        return "redirect:/chi-tiet-san-pham/hien-thi";
    }
    @PostMapping("/chi-tiet-san-pham/update")
    public String update(
            @RequestParam("namBh") int namBh ,
            @RequestParam("soLuongTon") int soLuongTon ,
            @RequestParam("giaNhap") Float giaNhap ,
            @RequestParam("giaBan") Float giaBan ,
            @RequestParam("moTa") String moTa ,
            @RequestParam("idSp") UUID idSp ,
            @RequestParam("idDsp") UUID idDsp ,
            @RequestParam("idMauSac") UUID idMauSac ,
            @RequestParam("idNsx") UUID idNsx,
            @RequestParam("id") UUID id

    ){
        SanPham sp  = sanPhamService.detail(idSp).get();
        DongSP dsp  = dongSpService.detail(idDsp).get();
        MauSac ms = mauSacService.detail(idMauSac).get();
        Nsx nsx = nsxService.detail(idNsx).get();

        ChiTietSanPham ds = ChiTietSanPham.builder()
                .id(id)
                .namBh(namBh)
                .soLuongTon(soLuongTon)
                .giaNhap(giaNhap)
                .giaBan(giaBan)
                .moTa(moTa)
                .idSp(sp)
                .idMauSac(ms)
                .idNsx(nsx)
                .idDongSp(dsp)
                .build();
        chiTietSanPhamService.update(ds);

        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

}
