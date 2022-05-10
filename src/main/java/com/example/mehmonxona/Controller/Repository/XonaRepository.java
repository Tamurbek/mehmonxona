package com.example.mehmonxona.Controller.Repository;

import com.example.mehmonxona.mehmonxona1.Hotels;
import com.example.mehmonxona.mehmonxona1.Xona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XonaRepository extends JpaRepository<Xona,Integer> {
    boolean existsXonaByXonaId(Integer xonaid);
    List<Xona> findXonaByHotels(Integer hotelId);
}
