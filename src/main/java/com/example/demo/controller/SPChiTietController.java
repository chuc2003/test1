package com.example.demo.controller;

import com.example.demo.entities.NhanVien;
import com.example.demo.entities.SPChiTiet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("sp-chi-tiet")
public class SPChiTietController {
    private List<SPChiTiet> ds = new ArrayList<>();

    public SPChiTietController(){
        this.ds.add(new SPChiTiet("SPCT1","KT1","MS1","SP1","1000","1500000",1));
        this.ds.add(new SPChiTiet("SPCT2","KT2","MS2","SP1","200","200000",0));
    }
    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("listSPCT",ds);
        return "sp_chi_tiet/index";
    }
    @GetMapping("create")
    public String create(){
        return "sp_chi_tiet/create";
    }
    @PostMapping("store")
    public String store(SPChiTiet spChiTiet){
        this.ds.add(spChiTiet);
        return "redirect:/sp-chi-tiet/index";
    }
    @GetMapping("delete/{maSPCT}")
    public String delete(@PathVariable("maSPCT") String maSPCT ){
        for (int i = 0; i < this.ds.size(); i++) {
            SPChiTiet spChiTiet = this.ds.get(i);
            if (spChiTiet.getMaSPCT().equals(maSPCT)){
                this.ds.remove(i);
            }
        }
        return "redirect:/sp-chi-tiet/index";
    }
    @GetMapping("edit/{maSPCT}")
    public String edit(@PathVariable("maSPCT") String maSPCT, Model model){
        for ( SPChiTiet spChiTiet : this.ds){
            if (spChiTiet.getMaSPCT().equals(maSPCT)){
                model.addAttribute("spct",spChiTiet);
//
            }
        }
        return "sp_chi_tiet/edit";
    }
    @PostMapping("update/{maSPCT}")
    public String update(@PathVariable("maSPCT") String maSPCT,SPChiTiet newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            SPChiTiet spChiTiet = this.ds.get(i);
            if (spChiTiet.getMaSPCT().equals(maSPCT)){
                this.ds.set(i,newValue);
            }
        }
        return "redirect:/sp-chi-tiet/index";
    }
}
