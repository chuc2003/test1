package com.example.demo.controller;

import com.example.demo.entities.KichThuoc;
import com.example.demo.entities.NhanVien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {
    private List<NhanVien> ds = new ArrayList<>();

    public NhanVienController(){
        this.ds.add(new NhanVien("NV1","Nguyen Van A","nv1","1",1));
        this.ds.add(new NhanVien("NV2","Nguyen Van B","nv2","2",0));
    }
    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("listNV",ds);
        return "nhan_vien/index";
    }
    @GetMapping("create")
    public String create(){
        return "nhan_vien/create";
    }
    @PostMapping("store")
    public String store(NhanVien nv){
        this.ds.add(nv);
        return "redirect:/nhan-vien/index";
    }
    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String maNhanVien ){
        for (int i = 0; i < this.ds.size(); i++) {
            NhanVien nv = this.ds.get(i);
            if (nv.getMa().equals(maNhanVien)){
                this.ds.remove(i);
            }
        }
        return "redirect:/nhan-vien/index";
    }
    @GetMapping("edit/{ma}")
    public String edit(@PathVariable("ma") String maNhanVien, Model model){
        for ( NhanVien nv : this.ds){
            if (nv.getMa().equals(maNhanVien)){
                model.addAttribute("nv",nv);
//
            }
        }
        return "nhan_vien/edit";
    }
    @PostMapping("update/{ma}")
    public String update(@PathVariable("ma") String maNhanVien,NhanVien newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            NhanVien nv = this.ds.get(i);
            if (nv.getMa().equals(maNhanVien)){
                this.ds.set(i,newValue);
            }
        }
        return "redirect:/nhan-vien/index";
    }
}
