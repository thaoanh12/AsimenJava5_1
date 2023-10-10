package com.example.demo.service.impl;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public void add(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public void update(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);

    }

    @Override
    public void delete(UUID id) {
        nhanVienRepository.deleteById(id);
    }

    @Override
    public Optional<NhanVien> detail(UUID id) {
        return nhanVienRepository.findById(id);
    }
}
