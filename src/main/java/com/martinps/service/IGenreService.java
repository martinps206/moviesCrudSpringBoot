package com.martinps.service;

import com.martinps.entity.Genre;

import java.util.List;

public interface IGenreService {

    public void save(Genre genre);
    public Genre findById(Long id);
    public void delete(Long id);
    public List<Genre> findAll();
}
