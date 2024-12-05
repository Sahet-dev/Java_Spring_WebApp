package com.sahet.simplewebapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Product {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

    @Column(name = "release_date")
    private Date releaseDate;

    private boolean available;
    private int quantity;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "image_type")
    private String imageType;

    @Lob
    @Column(name = "image_date")
    private byte[] imageDate;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private String name;
//    private String description;
//    private String brand;
//    private BigDecimal price;
//    private String category;
//
//    private Date releaseDate;
//    private boolean available;
//    private int quantity;
//
//    private String imageName;
//    private String imageType;
//
//    @Lob
//    private byte[] imageDate;


}

