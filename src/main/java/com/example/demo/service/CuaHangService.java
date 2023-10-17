package com.example.demo.service;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.CuaHang;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CuaHangService {
    List<CuaHang> getAll();

    void add(CuaHang cuaHang);

    void update(CuaHang cuaHang);

    void delete(UUID id);

    Optional<CuaHang> detail(UUID id);
}
