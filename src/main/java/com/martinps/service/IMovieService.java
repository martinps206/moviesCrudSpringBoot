package com.martinps.service;

import com.martinps.entity.Movie;

import java.util.List;

public interface IMovieService {

    public void save(Movie movie);
    public Movie findById(Long id);
    public void delete(Long id);
    public List<Movie> findAll();
}
