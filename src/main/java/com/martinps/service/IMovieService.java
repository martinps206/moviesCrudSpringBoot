package com.martinps.service;

import com.martinps.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import java.util.List;

public interface IMovieService {

    public void save(Movie movie);
    public Movie findById(Long id);
    public void delete(Long id);
    public List<Movie> findAll();
    public Page<Movie> findAll(PageRequest pageable);
}
