package com.example.demo.controller;

import com.example.demo.entities.SanPham;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("san-pham")
public class SanPhamController {
    private List<SanPham> ds = new ArrayList<>();

    public SanPhamController(){
        this.ds.add(new SanPham("SP1","sản phẩm 1",1));
        this.ds.add(new SanPham("SP2","sản phẩm 2",0));
    }
    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("listSP",ds);
        return "san_pham/index";
    }
    @GetMapping("create")
    public String create(){
        return "san_pham/create";
    }
    @PostMapping("store")
    public String store(SanPham sanPham){
        this.ds.add(sanPham);
        return "redirect:/san-pham/index";
    }

    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String maSanPham){
        for (int i = 0; i < this.ds.size(); i++) {
            SanPham sp = this.ds.get(i);
            if(sp.getMa().equals(maSanPham)){
                this.ds.remove(i);
            }
        }
        return "redirect:/san-pham/index";
    }
    @GetMapping("edit/{ma}")
    public String edit(@PathVariable("ma") String maSanPham,Model model){
        for ( SanPham sanPham : this.ds){
            if (sanPham.getMa().equals(maSanPham)){
                model.addAttribute("sp",sanPham);
            }
        }
        return "san_pham/edit";
    }
    @PostMapping("update/{ma}")
    public String update(@PathVariable("ma") String maSanPham, SanPham newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            SanPham sanPham = this.ds.get(i);
            if(sanPham.getMa().equals(maSanPham)){
                this.ds.set(i,newValue);
            }
        }
        return "redirect:/san-pham/index";
    }
}
