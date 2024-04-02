package com.example.demo.controller;

import com.example.demo.entities.HoaDonChiTiet;
import com.example.demo.entities.KichThuoc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hoa-don-ct")
public class HoaDonChiTietController {
    private List<HoaDonChiTiet> ds = new ArrayList<>();

    public HoaDonChiTietController(){
        this.ds.add(new HoaDonChiTiet("HC1","HD1","SC1","100","200",1));
        this.ds.add(new HoaDonChiTiet("HC2","HD2","SC2","40","600",0));
    }
    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("listHC",ds);
        return "hoa_don_ct/index";
    }
    @GetMapping("create")
    public String create(){
        return "hoa_don_ct/create";
    }
    @PostMapping("store")
    public String store(HoaDonChiTiet ct){
        this.ds.add(ct);
        return "redirect:/hoa-don-ct/index";
    }
    @GetMapping("delete/{maHDCT}")
    public String delete(@PathVariable("maHDCT") String maHoaDonChiTiet ){
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDonChiTiet hc = this.ds.get(i);
            if (hc.getMaHDCT().equals(maHoaDonChiTiet)){
                this.ds.remove(i);
            }
        }
        return "redirect:/hoa-don-ct/index";
    }
    @GetMapping("edit/{maHDCT}")
    public String edit(@PathVariable("maHDCT") String maHoaDonChiTiet, Model model){
        for ( HoaDonChiTiet hc : this.ds){
            if (hc.getMaHDCT().equals(maHoaDonChiTiet)){
                model.addAttribute("hc",hc);
            }
        }
        return "hoa_don_ct/edit";
    }
    @PostMapping("update/{maHDCT}")
    public String update(@PathVariable("maHDCT") String maHoaDonChiTiet,HoaDonChiTiet newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDonChiTiet hc = this.ds.get(i);
            if (hc.getMaHDCT().equals(maHoaDonChiTiet)){
                this.ds.set(i,newValue);
            }
        }
        return "redirect:/hoa-don-ct/index";
    }
}
