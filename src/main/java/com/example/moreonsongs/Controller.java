package com.example.moreonsongs;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;



@org.springframework.stereotype.Controller
public class Controller {

    ArrayList<Song> songs = new ArrayList<>();
    @GetMapping("/songform")
    public String loadForm(Model model){
        model.addAttribute("song", new Song());
        return "songform";
    }

    @PostMapping("/confirmSong") // check to change
    public String loadFromPage(@Valid Song song, BindingResult result){
        if(result.hasErrors()){
            return "songform";
        }
        songs.add(song);
        return "confirmsong";
    }

    @RequestMapping("/allSongs")
    public String allSongs(Model model){
        model.addAttribute("songs", songs);
        return "allSongs";
    }
}
