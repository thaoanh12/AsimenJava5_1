package com.example.demo.controller;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.CuaHang;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

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
    @PostMapping("/nhan-vien/add")
    public String nhanvienadd(
            @RequestParam("ma") String ma ,
            @RequestParam("ho") String ho ,
            @RequestParam("ten") String ten ,
            @RequestParam("tenDem") String tendem ,
            @RequestParam("ngaySinh") String ngaySinh ,
            @RequestParam("diaChi") String diaChi ,
            @RequestParam("sdt") String sdt ,
            @RequestParam("gioiTinh") String gioiTinh ,
            @RequestParam("matKhau") String matKhau ,
            @RequestParam("chucVu") String chucVu ,
            @RequestParam("cuaHang") String cuaHang ,
            @RequestParam("trangThai") String trangThai

    ){
        CuaHang ch = cuaHangService.detail(UUID.fromString(cuaHang)).get();
        ChucVu cv = chucVuService.detail(UUID.fromString(chucVu)).get();
        NhanVien nv = NhanVien.builder()
                .ma(ma)
                .ho(ho)
                .ten(ten)
                .tenDem(tendem)
                .gioiTinh(gioiTinh)
                .ngaysinh(ngaySinh)
                .diaChi(diaChi)
                .sdt(sdt)
                .matKhau(matKhau)
                .idCv(cv)
                .idCh(ch)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        nhanVienService.add(nv);

        return "redirect:/nhan-vien/hien-thi";
    }
    @GetMapping("/nhan-vien/remover/{id}")
    public String delete(@PathVariable("id") UUID id){
        nhanVienService.delete(id);
        return "redirect:/nhan-vien/hien-thi";
    }
    @GetMapping("/nhan-vien/detail/{id}")
    public String detail(@PathVariable("id") UUID id ,Model model){
        NhanVien ds = nhanVienService.detail(id).get();
        model.addAttribute("nvs" , ds);
        model.addAttribute("cv" , chucVuService.getAll());
        model.addAttribute("ch" , cuaHangService.getAll());
        return "nhanvien/NhanVien";
    }
    @PostMapping("/nhan-vien/update")
    public String nhanvienupdate(
            @RequestParam("ma") String ma ,
            @RequestParam("ho") String ho ,
            @RequestParam("ten") String ten ,
            @RequestParam("tenDem") String tendem ,
            @RequestParam("ngaySinh") String ngaySinh ,
            @RequestParam("diaChi") String diaChi ,
            @RequestParam("sdt") String sdt ,
            @RequestParam("gioiTinh") String gioiTinh ,
            @RequestParam("matKhau") String matKhau ,
            @RequestParam("chucVu") String chucVu ,
            @RequestParam("cuaHang") String cuaHang ,
            @RequestParam("trangThai") String trangThai,
            @RequestParam("id") UUID id

    ){
        CuaHang ch = cuaHangService.detail(UUID.fromString(cuaHang)).get();
        ChucVu cv = chucVuService.detail(UUID.fromString(chucVu)).get();
        NhanVien nv = NhanVien.builder()
                .id(id)
                .ma(ma)
                .ho(ho)
                .ten(ten)
                .tenDem(tendem)
                .gioiTinh(gioiTinh)
                .ngaysinh(ngaySinh)
                .diaChi(diaChi)
                .sdt(sdt)
                .matKhau(matKhau)
                .idCv(cv)
                .idCh(ch)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        nhanVienService.update(nv);

        return "redirect:/nhan-vien/hien-thi";
    }
}
