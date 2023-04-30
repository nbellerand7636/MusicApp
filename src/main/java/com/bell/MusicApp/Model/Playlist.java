package com.bell.MusicApp.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="playlist")
@Data
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long playlistId;
    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
