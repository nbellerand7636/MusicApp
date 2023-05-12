package com.bell.MusicApp.Repository;

import com.bell.MusicApp.Model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist,Long> {

}
