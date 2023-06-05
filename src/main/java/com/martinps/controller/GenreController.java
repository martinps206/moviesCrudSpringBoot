package com.martinps.controller;

import com.martinps.dao.IGenreRepositoryImplement;
import com.martinps.entity.Genre;
import com.martinps.service.IGenreService;
import org.springframework.web.bind.annotation.*;

@RestController
public class GenreController {

    private final IGenreService iGenreService;

    public GenreController(IGenreService iGenreService){
        this.iGenreService = iGenreService;
    }
    @PostMapping("genre")
    public String save(@RequestParam String name){
        Genre genre = new Genre();
        genre.setName(name);
        iGenreService.save(genre);
        return  genre.toString();
    }

    @GetMapping("genres/{id}")
    public String searchByID(@PathVariable(name = "id") Long id){
        return iGenreService.findById(id).getName();
    }


}
