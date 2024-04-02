package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SPChiTiet {
    private String maSPCT;
    private String idKichThuoc;
    private String idMauSac;
    private String idSanPham;
    private String soLuong;
    private String donGia;
    private int trangThai;

}
