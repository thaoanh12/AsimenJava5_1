package com.example.demo.service;

import com.example.demo.entity.DongSP;
import com.example.demo.entity.MauSac;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DongSpService {
    List<DongSP> getAll();
    void add(DongSP dongSP);
    void update(DongSP dongSP);
    void delete(UUID id);
    Optional<DongSP> detail(UUID id);
}
