package com.example.demo.service;

import com.example.demo.entity.NhanVien;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NhanVienService {
    List<NhanVien> getAll();

    void add(NhanVien nhanVien);

    void update(NhanVien nhanVien);

    void delete(UUID id);

    Optional<NhanVien> detail(UUID id);
}
