package com.example.demo.service.impl;

import com.example.demo.entity.Nsx;
import com.example.demo.repository.NSXRepository;
import com.example.demo.service.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NsxServiceImpl implements NSXService {
    @Autowired
    private NSXRepository nsxRepository;

    @Override
    public List<Nsx> getAll() {
        return nsxRepository.findAll();
    }

    @Override
    public void add(Nsx nsx) {
        nsxRepository.save(nsx);
    }

    @Override
    public void update(Nsx nsx) {
        nsxRepository.save(nsx);
    }

    @Override
    public void delete(UUID id) {
        nsxRepository.deleteById(id);
    }

    @Override
    public Optional<Nsx> detail(UUID id) {
        return nsxRepository.findById(id);
    }
}
