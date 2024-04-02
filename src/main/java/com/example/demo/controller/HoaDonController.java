package com.example.demo.controller;

import com.example.demo.entities.HoaDon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("hoa-don")
public class HoaDonController {
    private List<HoaDon> ds = new ArrayList<>();
    public HoaDonController(){
        this.ds.add(new HoaDon("HD1","NV1","KH1", "2023-12-11",1));
        this.ds.add(new HoaDon("HD2","NV2","KH2", "2024-01-12",0));
    }
    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("listHD",ds);
        return "hoa_don/index";
    }
    @GetMapping("create")
    public String create(){
        return "hoa_don/create";
    }
    @PostMapping("store")
    public String store(HoaDon hoaDon){
        this.ds.add(hoaDon);
        return "redirect:/hoa-don/index";
    }
    @GetMapping("delete/{maHoaDon}")
    public String delete(@PathVariable("maHoaDon") String maHoaDon){
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDon hd = this.ds.get(i);
            if(hd.getMaHoaDon().equals(maHoaDon)){
                this.ds.remove(i);
            }
        }
        return "redirect:/hoa-don/index";
    }
    @GetMapping("edit/{maHoaDon}")
    public String edit(@PathVariable("maHoaDon") String maHoaDon, Model model){
        for (HoaDon hd : this.ds){
            if (hd.getMaHoaDon().equals(maHoaDon)){
                model.addAttribute("hd",hd);

//                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//                ParsePosition parsePosition = new ParsePosition(0);
//                Date date = format.parse(hd.getNgayMuaHang(),parsePosition);

            }
        }
        return "hoa_don/edit";
    }

    @PostMapping("update/{maHoaDon}")
    public String update(@PathVariable("maHoaDon") String maHoaDon,HoaDon newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDon hd = this.ds.get(i);
            if(hd.getMaHoaDon().equals(maHoaDon)){
                this.ds.set(i,newValue);
            }
        }
        return "redirect:/hoa-don/index";
    }


    @GetMapping("/search")
    public String timKiem(@RequestParam("maHoaDon") String maHD ,
                             @RequestParam("idNhanVien") String idNhanVien,
                             @RequestParam("idKhachHang") String idKhachHang,
                             Model model){
        List<HoaDon> listCon = new ArrayList<>();
        if (maHD == ""){
            for(HoaDon kt : ds){
                if(kt.getIdNhanVien().contains(idNhanVien) & kt.getIdKhachHang().contains(idKhachHang)){
                    listCon.add(kt);
                }
            }
            model.addAttribute("listHD",listCon);
            return "hoa_don/index";
        }
        if(idNhanVien == ""){
            for(HoaDon kt : ds){
                if(kt.getMaHoaDon().contains(maHD) & kt.getIdKhachHang().contains(idKhachHang)){
                    listCon.add(kt);
                }
            }
            model.addAttribute("listHD",listCon);
            return "hoa_don/index";
        }
        if(idKhachHang == ""){
            for(HoaDon kt : ds){
                if(kt.getMaHoaDon().contains(maHD)){
                    listCon.add(kt);
                }
            }
            model.addAttribute("listHD",listCon);
            return "hoa_don/index";
        }
        if (maHD == "" & idNhanVien == ""){
            for(HoaDon kt : ds){
                if( kt.getIdKhachHang().contains(idKhachHang)){
                    listCon.add(kt);
                }
            }
            model.addAttribute("listHD",listCon);
            return "hoa_don/index";
        }
        if (maHD == "" & idKhachHang == ""){
                    for(HoaDon kt : ds){
                        if( kt.getIdNhanVien().contains(idNhanVien)){
                            listCon.add(kt);
                        }
                    }
                    model.addAttribute("listHD",listCon);
                    return "hoa_don/index";
                }
        if (idNhanVien == "" & idKhachHang == ""){
                    for(HoaDon kt : ds){
                        if( kt.getMaHoaDon().contains(maHD)){
                            listCon.add(kt);
                        }
                    }
                    model.addAttribute("listHD",listCon);
                    return "hoa_don/index";
                }

        for(HoaDon kt : ds){
            if(kt.getMaHoaDon().contains(maHD) & kt.getIdNhanVien().contains(idNhanVien) & kt.getIdKhachHang().contains(idKhachHang)){
                listCon.add(kt);
            }
            model.addAttribute("listHD",listCon);
        }
        return "hoa_don/index";
    }
    @GetMapping("/search-date")
    public String timNgay(@RequestParam("ngayMuaHang") String ngayMuaHang, Model model){
        List<HoaDon> listCon = new ArrayList<>();
        for(HoaDon kt : ds){
            if(kt.getNgayMuaHang() == ngayMuaHang){
                listCon.add(kt);
            }
        }
        model.addAttribute("listHD",listCon);
        return "hoa_don/index";
    }
    @GetMapping("/loc")
    public String loc(@RequestParam ("trangThai") int trangThaiKT,Model model){
        List<HoaDon> listTT = new ArrayList<>();
        for(HoaDon kt : ds){
            if(kt.getTrangThai() == trangThaiKT){
                listTT.add(kt);
            }
        }
        model.addAttribute("listHD",listTT);
        return "hoa_don/index";
    }
}
