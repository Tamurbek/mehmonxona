package com.example.mehmonxona.Controller.Repository;

import com.example.mehmonxona.mehmonxona1.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelsRepository extends JpaRepository<Hotels,Integer> {
    boolean existsHotelsByHotelName(String hotelname);
}
