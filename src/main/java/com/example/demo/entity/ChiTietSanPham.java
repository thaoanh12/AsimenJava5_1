package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ChiTietSanPham {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;
    @Column(name = "NamBH")
    private int namBh ;
    @Column(name = "MoTa")
    private String moTa ;
    @Column(name = "SoLuongTon")
    private int soLuongTon ;
    @Column(name = "GiaNhap")
    private Float giaNhap ;
    @Column(name = "GiaBan")
    private Float giaBan ;
    @ManyToOne
    @JoinColumn(name = "IdSP" , referencedColumnName = "Id")
    private SanPham idSp ;
    @ManyToOne
    @JoinColumn(name = "IdNsx" , referencedColumnName = "Id")
    private Nsx idNsx ;
    @ManyToOne
    @JoinColumn(name = "IdMauSac" , referencedColumnName = "Id")
    private MauSac idMauSac ;
    @ManyToOne
    @JoinColumn(name = "IdDongSP" , referencedColumnName = "Id")
    private DongSP idDongSp ;
}
