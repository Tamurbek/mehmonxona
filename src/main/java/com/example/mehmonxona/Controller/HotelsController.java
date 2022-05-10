package com.example.mehmonxona.Controller;

import com.example.mehmonxona.Controller.Repository.HotelsRepository;
import com.example.mehmonxona.mehmonxona1.Hotels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/hotel")
public class HotelsController {
    @Autowired
    HotelsRepository hotelsRepository;
    @PostMapping
    public String set_Hotel(@RequestBody Hotels hotels){
        Boolean holat=hotelsRepository.existsHotelsByHotelName(hotels.getHotelName());
        if (!holat){
            hotelsRepository.save(hotels);
            return "Mehmonxona nomi joylandi";
        }
        return "Bunday mehmonxona nomi mavjud!!";
    }
    @GetMapping
    public List<Hotels> gethotels(){
        List<Hotels> hotelsList=hotelsRepository.findAll();
        return hotelsList;
    }

    @PutMapping("/yangi/{id}")
    public String yangilsh(@PathVariable Integer Id,@RequestBody Hotels hotels){
        Optional<Hotels> optionalHotels=hotelsRepository.findById(Id);
        if(optionalHotels.isPresent()){
            Hotels hotels1=optionalHotels.get();
            hotels1.setHotelName(hotels.getHotelName());
            hotelsRepository.save(hotels1);
            return "Ma`lumot yangilandi";
        }
        return "Bunday mehmonxona mavjud emas!!";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Optional<Hotels> optionalHotels=hotelsRepository.findById(id);
        if (optionalHotels.isPresent()){
            hotelsRepository.deleteById(id);
            return "Malumot O`chirildi";
        }
        return "Bunday mehmonxona mavjud emas!!";
    }

}
