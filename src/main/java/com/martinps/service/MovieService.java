package com.martinps.service;

import com.martinps.dao.IMoviesRepositoryImplement;
import com.martinps.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private IMoviesRepositoryImplement iMoviesRepositoryImplement;
    @Override
    public void save(Movie movie) {
        iMoviesRepositoryImplement.save(movie);
    }

    @Override
    public Movie findById(Long id) {
        return iMoviesRepositoryImplement.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        iMoviesRepositoryImplement.deleteById(id);
    }

    @Override
    public List<Movie> findAll() {
        return (List<Movie>) iMoviesRepositoryImplement.findAll();
    }
}
