package com.example.demo.service;

import com.example.demo.entity.ChiTietSanPham;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChiTietSanPhamService {
    List<ChiTietSanPham> getAll();
    void add(ChiTietSanPham chiTietSanPham );
    void update(ChiTietSanPham chiTietSanPham );
    void delete(UUID id);
    Optional<ChiTietSanPham> detail(UUID id);
}
