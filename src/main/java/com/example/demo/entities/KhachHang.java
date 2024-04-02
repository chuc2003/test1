package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {
    private String ma;
    private String ten;
    private String soDienThoai;
    private int trangThai;

}
