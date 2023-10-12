package com.example.demo.service;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface KhachHangService {
    List<KhachHang> getAll();
    void add(KhachHang khachHang);
    void update(KhachHang khachHang);
    void delete(UUID id);
    Optional<KhachHang> detail(UUID id);
}
