package com.example.demo.controller;

import com.example.demo.entities.KhachHang;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {
    private List<KhachHang> ds = new ArrayList<>();

    public KhachHangController(){
        this.ds.add(new KhachHang("KH1","Nguyen Van A","0987654321",0));
        this.ds.add(new KhachHang("KH2","Nguyen Van B","0987654321",1));
    }

    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("listKH",ds);
        return "khach_hang1/index";
    }
    @GetMapping("create")
    public String create(){
        return "khach_hang1/create";
    }

    @PostMapping("store")
    public String store(KhachHang khachHang){
        this.ds.add(khachHang);
        return "redirect:/khach-hang/index";
    }
    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String maKhachHang){
        for (int i = 0; i < this.ds.size(); i++) {
            KhachHang khachHang = this.ds.get(i);
            if(khachHang.getMa().equals(maKhachHang)){
                this.ds.remove(i);
            }
        }
        return "redirect:/khach-hang/index";
    }

    @GetMapping("edit/{ma}")
    public String edit(@PathVariable("ma") String maKhachHang,Model model){
        for( KhachHang khachHang: this.ds ){
            if(khachHang.getMa().equals(maKhachHang)){
                model.addAttribute("kh",khachHang);
            }
        }
        return "khach_hang1/edit";
    }

    @PostMapping("update/{ma}")
    public String update(@PathVariable("ma") String maKhachHang, KhachHang newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            KhachHang khachHang = this.ds.get(i);
            if(khachHang.getMa().equals(maKhachHang)){
                this.ds.set(i,newValue);
            }
        }
        return "redirect:/khach-hang/index";
    }


}
