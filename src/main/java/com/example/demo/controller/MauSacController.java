package com.example.demo.controller;

import com.example.demo.entities.MauSac;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("mau-sac")
public class MauSacController {
    private List<MauSac> ds = new ArrayList<>();

    public MauSacController()
    {
        this.ds.add(new MauSac("MS1", "Red", 1));
        this.ds.add(new MauSac("MS2", "Yellow", 0));
    }

    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("listMS",ds);
        return "mau_sac/index";
    }
    @GetMapping("/create") // điền dữ liệu
    private String create(){
        return "mau_sac/create";
    }
    @PostMapping("/store") // lưu dữ liệu
    public String store(MauSac ms){
        System.out.println(ms.getMa());
        System.out.println(ms.getTen());
        System.out.println(ms.getTrangThai());
        this.ds.add(ms);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String maMauSac){
        for (int i = 0; i < this.ds.size(); i++){
            MauSac ms = this.ds.get(i);
            if(ms.getMa().equals(maMauSac)){
                this.ds.remove(i);
            }
        }
        return "redirect:/mau-sac/index";
    }
    @GetMapping("edit/{ma}")
    public String edit(@PathVariable("ma") String maMauSac,Model model){
        for (MauSac ms: this.ds ){
            if(ms.getMa().equals(maMauSac)){
                model.addAttribute("ms",ms);
            }
        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        return "mau_sac/edit";
    }

    @PostMapping("update/{ma}")
    public String update(MauSac newValue, @PathVariable("ma") String maMauSac ){
        for (int i = 0; i < this.ds.size(); i++){
            MauSac ms = this.ds.get(i);
            if(ms.getMa().equals(maMauSac)){
                this.ds.set(i, newValue);
            }
        }

        return "redirect:/mau-sac/index";
    }





    @GetMapping("")
    public String Login() {
        return "mau-sac";
    }

}
