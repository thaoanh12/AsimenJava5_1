package com.example.demo.service;

import com.example.demo.entity.ChucVu;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChucVuService {
    List<ChucVu> getAll();
    void add(ChucVu chucVu);
    void update(ChucVu chucVu);
    void delete(UUID id);
    Optional<ChucVu> detail(UUID id);

}
