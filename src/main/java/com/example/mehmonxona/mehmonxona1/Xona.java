package com.example.mehmonxona.mehmonxona1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Xona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer xonaRaqami;
    @Column(nullable = false)
    private Integer xonaId;
    @Column(nullable = false)
    private int qavat;
    @Column(nullable = false)
    private int xonalariSoni;
    @ManyToOne
    Hotels hotels;
}
