package com.bell.MusicApp.Service;

import com.bell.MusicApp.Model.Song;
import com.bell.MusicApp.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;

    public Song getSong(Long songId){
        return songRepository.findById(songId).get();
    }

    public Song getSong(String title) {
        return songRepository.findByTitle(title);
    }
    public List<Song> getAllSongs(){
        return songRepository.findAll();
    }
    public void addSong(Song song){
        songRepository.save(song);
    }

}
