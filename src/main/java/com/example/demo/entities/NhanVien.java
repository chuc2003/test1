package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {
    private String ma;
    private String ten;
    private String tenDangNhap;
    private String matKhau;
    private int trangThai;
}
