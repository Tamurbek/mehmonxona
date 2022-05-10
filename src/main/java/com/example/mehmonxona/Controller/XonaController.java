package com.example.mehmonxona.Controller;

import com.example.mehmonxona.Controller.Repository.HotelsRepository;
import com.example.mehmonxona.Controller.Repository.XonaRepository;
import com.example.mehmonxona.DTO.XonaDTO;
import com.example.mehmonxona.mehmonxona1.Hotels;
import com.example.mehmonxona.mehmonxona1.Xona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/xona")
public class XonaController {
    @Autowired
    XonaRepository xonaRepository;
    @Autowired
    HotelsRepository hotelsRepository;
    @RequestMapping
    public String set_xona(@RequestBody XonaDTO xona){
        Optional<Hotels> optional=hotelsRepository.findById(xona.getHotelsId());
        if(optional.isPresent()){
            Xona xona1=new Xona();
            xona1.setXonaId(xona.getXonaId());
            xona1.setQavat(xona.getQavat());
            xona1.setXonalariSoni(xona.getXonalariSoni());
            xona1.setHotels(optional.get());
            xonaRepository.save(xona1);
            return "Xona ma`lumotlari joylandi";
        }
        return "Bunday xona mavjud";
    }
    @GetMapping(value = "/{id}")
    public List<Xona> select(@PathVariable Integer id){
        Optional<Hotels> optionalHotels=hotelsRepository.findById(id);
        if(optionalHotels.isPresent()){
            List<Xona> xonaList=xonaRepository.findXonaByHotels(id);
            return xonaList;
        }
        return null;
    }
}
