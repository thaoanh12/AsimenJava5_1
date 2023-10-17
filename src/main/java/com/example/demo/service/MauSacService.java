package com.example.demo.service;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.Nsx;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MauSacService {
    List<MauSac> getAll();

    void add(MauSac mauSac);

    void update(MauSac mauSac);

    void delete(UUID id);

    Optional<MauSac> detail(UUID id);
}
