package com.example.demo.service.impl;

import com.example.demo.entity.DongSP;
import com.example.demo.repository.DongSpRepository;
import com.example.demo.service.DongSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DongSpServiceImpl implements DongSpService {
    @Autowired
    private DongSpRepository dongSpRepository;

    @Override
    public List<DongSP> getAll() {
        return dongSpRepository.findAll();
    }

    @Override
    public void add(DongSP dongSP) {
        dongSpRepository.save(dongSP);
    }

    @Override
    public void update(DongSP dongSP) {
        dongSpRepository.save(dongSP);
    }

    @Override
    public void delete(UUID id) {
        dongSpRepository.deleteById(id);
    }

    @Override
    public Optional<DongSP> detail(UUID id) {
        return dongSpRepository.findById(id);
    }
}
