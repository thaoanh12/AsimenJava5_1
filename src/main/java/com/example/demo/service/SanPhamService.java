package com.example.demo.service;

import com.example.demo.entity.Nsx;
import com.example.demo.entity.SanPham;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SanPhamService {
    List<SanPham> getAll();
    void add(SanPham sanPham);
    void update(SanPham sanPham);
    void delete(UUID id);
    Optional<SanPham> detail(UUID id);
}
