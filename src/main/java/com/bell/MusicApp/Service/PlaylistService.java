package com.bell.MusicApp.Service;

import com.bell.MusicApp.Model.Playlist;
import com.bell.MusicApp.Model.Song;
import com.bell.MusicApp.Repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PlaylistService {
    @Autowired
    PlaylistRepository playlistRepository;

    public Playlist getPlaylist(Long id) {
        return playlistRepository.findById(id).get();
    }
    public void addPLaylist(Playlist playlist){
        playlistRepository.save(playlist);
    }
    public List<Playlist> getPlaylists() {
        return playlistRepository.findAll();
    }
    public List<Song>playlistSongs(Long playlistID){
        Playlist p = playlistRepository.findById(playlistID).get();
        return p.getSongList();
    }

    public void addSong(Long playlistId,Song song){
        Playlist p =playlistRepository.findById(playlistId).orElse(null);
        List<Song>songList=p.getSongList();
        songList.add(song);
        p.setSongList(songList);
        playlistRepository.save(p);
    }
}