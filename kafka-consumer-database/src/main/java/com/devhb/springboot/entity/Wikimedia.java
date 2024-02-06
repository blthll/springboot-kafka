package com.devhb.springboot.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "wikimedia_recentchange")
@Data
public class Wikimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob()
    @Column(columnDefinition = "BLOB")
    private String wikiEventData;
}
