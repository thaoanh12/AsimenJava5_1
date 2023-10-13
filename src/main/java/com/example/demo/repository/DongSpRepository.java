package com.example.demo.repository;

import com.example.demo.entity.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DongSpRepository extends JpaRepository<DongSP, UUID> {
}
