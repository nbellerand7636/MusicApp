package com.bell.MusicApp.Controller;

import com.bell.MusicApp.Model.Playlist;
import com.bell.MusicApp.Model.Song;
import com.bell.MusicApp.Service.PlaylistService;
import com.bell.MusicApp.Service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;
    @Autowired
    private SongService songService;
    @GetMapping("/playlists")
    public List<Playlist>playlists(){
        return playlistService.getPlaylists();
    }
    @GetMapping("/playlistSongs/{playlistId}")
    public  List<Song>playlistSongs(@PathVariable Long playlistId){
        return playlistService.playlistSongs(playlistId);
    }
    @PostMapping("/playlists/{playlistId}/{songId}")
    public void addSong(@PathVariable Long playlistId,@PathVariable Long songId){
        Song song = songService.getSong(songId);
        playlistService.addSong(playlistId,song);
    }


}
