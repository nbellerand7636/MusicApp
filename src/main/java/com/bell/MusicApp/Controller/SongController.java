package com.bell.MusicApp.Controller;

import com.bell.MusicApp.Model.Song;
import com.bell.MusicApp.Service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping("/songs")
    public List<Song> songList(){
        return songService.getAllSongs();
    }
    @GetMapping("/song/{songId}")
    public Song getSong(@PathVariable Long songId){
        return songService.getSong(songId);
    }
    @PostMapping("/song")
    public void addSong(@RequestBody Song song){
        songService.addSong(song);
    }
    @GetMapping("/{songName}")
    public Song getSongBySongName(@PathVariable String songName){
        return songService.getSong(songName);
    }

}
