package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class HoaDon {
    private String maHoaDon;
    private String idNhanVien;
    private String idKhachHang;
    private String ngayMuaHang;
    private int trangThai;

}
