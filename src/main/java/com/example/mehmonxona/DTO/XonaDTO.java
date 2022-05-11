package com.example.mehmonxona.DTO;

import com.example.mehmonxona.mehmonxona1.Hotels;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Data
public class XonaDTO {
    private Integer xonaRaqami;
    private Integer xonaId;
    private int qavat;
    private int xonalariSoni;
    private Integer hotelId;
}
