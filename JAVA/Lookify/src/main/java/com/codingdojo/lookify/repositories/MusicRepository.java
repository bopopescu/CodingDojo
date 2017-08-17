package com.codingdojo.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.lookify.models.Music;


public interface MusicRepository extends CrudRepository<Music, Long>{
	public List<Music> findAllByOrderByRatingDesc();
    List<Music> findByArtistContaining(String search);
    Long countByArtistContaining(String search);

}
