package com.bell.MusicApp.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="song")
@Data
public class Song {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String title;
    @Column
    private String artist;
    @Column
    private String album;


}
