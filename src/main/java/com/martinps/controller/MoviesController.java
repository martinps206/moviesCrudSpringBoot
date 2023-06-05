package com.martinps.controller;

import com.martinps.entity.Actor;
import com.martinps.entity.Genre;
import com.martinps.entity.Movie;
import com.martinps.service.IActorService;
import com.martinps.service.IFileService;
import com.martinps.service.IGenreService;
import com.martinps.service.IMovieService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class MoviesController {

    private final IMovieService iMovieService;
    private final IGenreService iGenreService;
    private final IActorService iActorService;
    private final IFileService iFileService;

    public MoviesController(IMovieService iMovieService, IGenreService iGenreService, IActorService iActorService, IFileService iFileService) {
        this.iMovieService = iMovieService;
        this.iGenreService = iGenreService;
        this.iActorService = iActorService;
        this.iFileService = iFileService;
    }

    @GetMapping("/movie")
    public String create(Model model){
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        model.addAttribute("genres", iGenreService.findAll());
        model.addAttribute("actors", iActorService.findAll());
        model.addAttribute("title", "New Movies");
        return "movie";
    }

    @GetMapping("/movie/{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model){
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        model.addAttribute("genres", iGenreService.findAll());
        model.addAttribute("actors", iActorService.findAll());
        model.addAttribute("title", "Edit movie");
        return "movies";
    }


    @PostMapping("/movie")
    public String save(@Valid Movie movie, BindingResult bindingResult, @ModelAttribute(name = "ids") String ids, Model model, @RequestParam("file")MultipartFile multipartFile){

        if(bindingResult.hasErrors()){
            model.addAttribute("genres", iGenreService.findAll());
            model.addAttribute("actors", iActorService.findAll());
            System.out.println("hay un error....." + movie.getName() + movie.getGenre().getId());
            return "movie";
        }

        if(!multipartFile.isEmpty()){

            String file = movie.getName() + getExtension(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            movie.setImage(file);
            try {
                iFileService.save(file, multipartFile.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }else{
            movie.setImage("movie.jpg");
        }

        List<Long> idsActors = Arrays.stream(ids.split(", ")).map(Long::parseLong).collect(Collectors.toList());
        List<Actor> actors = iActorService.findAllById(idsActors);
        movie.setActors(actors);
        iMovieService.save(movie);
        return "redirect:home";
    }

    private String getExtension(String file){
        return file.substring(file.lastIndexOf("."));
    }

    @GetMapping({"/", "/home", "/index"})
    public String home(Model model) {
        model.addAttribute("movies", iMovieService.findAll());
        model.addAttribute("msj", "Updated catalog 2023");
        model.addAttribute("tipMsj", "success");
        return "home";

    }
/*
    @GetMapping("movies/{id}")
    public String searchByID(@PathVariable(name = "id") Long id){
        return iMovieService.findById(id).getName();
    }

*/
}
