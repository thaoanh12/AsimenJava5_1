package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "CuaHang")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CuaHang {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;
    @Column(name = "Ma")
    private String ma ;
    @Column(name = "Ten")
    private String ten ;
    @Column(name = "DiaChi")
    private String diaChi ;
    @Column(name = "ThanhPho")
    private String thanhPho;
    @Column(name = "QuocGia")
    private String quocGia ;
}
