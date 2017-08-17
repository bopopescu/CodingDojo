package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.services.MusicService;


import com.codingdojo.lookify.models.Music;


@Controller
public class MusicControllers {
	private final MusicService musicService;
	
	public MusicControllers(MusicService musicService) {
		this.musicService = musicService;
	}
	
	@RequestMapping("/dashboard")
	public String songs(Model model, @ModelAttribute("music") Music music) {
		List<Music> songs = musicService.allSongs();
		System.out.println(songs);
		for(int i = 0; i < songs.size(); i++) {
			System.out.println(songs.get(i).getTitle());
		}
		model.addAttribute("allsongs", songs);
		return "songs.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Music music) {
		return "newSong.jsp";
	}

	
	@PostMapping("/songs/new")
	public String createnewSong(@Valid @ModelAttribute("song") Music music, BindingResult result) {
		if(result.hasErrors()) {
			return "newSong.jsp"; 
		}
		else {
			musicService.addSong(music);
			return "redirect:/dashboard";
		}
		
	}
	
//	@RequestMapping(value="/search/${getsearch}")
//	public String searchPage(@ModelAttribute("music") Music music,  @PathVariable("getsearch") String search) {
//		return "searchArtist.jsp";
//	}
	
	@RequestMapping(value="/search")
	public String searchArtist(Model model, @Valid @ModelAttribute("music") Music music, BindingResult result, @RequestParam String search) {
		List<Music> thesongsangByArtists = musicService.findArtist(search);
		System.out.println(thesongsangByArtists);
		for(int i = 0; i < thesongsangByArtists.size(); i++) {
			System.out.println(thesongsangByArtists.get(i).getTitle());
		}
		model.addAttribute("search", search);
		model.addAttribute("songsSangByArtist", thesongsangByArtists);
		return "searchArtist.jsp";
	}
	
	@RequestMapping("/songs/{id}")
	public String newSong(Model model, @PathVariable("id") Long index) {
		Music thesong = musicService.findSongsByIndex(index);
		System.out.println("id"+thesong);
		model.addAttribute("song", thesong);
		return "showthatSong.jsp";
	}
	
	///songs/delete/
	@RequestMapping(value="/songs/delete/{id}")
	public String deleteSong(@PathVariable("id") Long index) {
		musicService.destroySong(index);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/topten")
	public String topTen(Model model) {
		List<Music> topsongs = musicService.getTopTen();
		System.out.println(topsongs);
		for(int i = 0; i < topsongs.size(); i++) {
			System.out.println(topsongs.get(i).getArtist());
		}
		model.addAttribute("topsongs", topsongs);
		return "topTen.jsp";
	}
	
	
}
