package com.bell.MusicApp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="song")
@Data

public class Song {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String title;
    @Column
    private String artist;
    @Column
    private String album;

    @JsonIgnore
    @ManyToMany(mappedBy = "songList")
    private List<Playlist>playlists;



}
