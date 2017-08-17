package com.codingdojo.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Music;
import com.codingdojo.lookify.repositories.MusicRepository;

@Service
public class MusicService {
	private final MusicRepository musicRepository;
	
	public MusicService(MusicRepository musicRepository) {
		this.musicRepository = musicRepository;
	}
	
	public List<Music> allSongs(){
		return (List<Music>) musicRepository.findAll();
	}

	public void addSong(Music music) {
		musicRepository.save(music);
		
	}

	public Music findSongsByIndex(Long index) {
		if(musicRepository.findOne(index) != null) {
			return musicRepository.findOne(index);
		}
		else {
			return null;
		}
	}

	public void destroySong(Long index) {
		if( musicRepository.exists(index)) {
			musicRepository.delete(index);
		}
		
	}
	
	public List<Music> findArtist(String search){
		return (List<Music>) musicRepository.findByArtistContaining(search);
	}
	
	public List<Music> getTopTen(){
		return (List<Music>) musicRepository.findAllByOrderByRatingDesc();
	}

}
