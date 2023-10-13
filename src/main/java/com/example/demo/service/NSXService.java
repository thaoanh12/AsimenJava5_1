package com.example.demo.service;

import com.example.demo.entity.Nsx;
import com.example.demo.entity.NhanVien;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NSXService {
    List<Nsx> getAll();
    void add(Nsx nsx);
    void update(Nsx nsx);
    void delete(UUID id);
    Optional<Nsx> detail(UUID id);
}
