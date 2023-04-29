package com.bell.MusicApp.Repository;

import com.bell.MusicApp.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song,Long> {

    Song findByTitle(String title);
}
