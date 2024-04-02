package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HoaDonChiTiet {
    private String maHDCT;
    private String idHoaDon;
    private String idSPCT;
    private String soLuong;
    private String donGia;
    private int trangThai;
}
