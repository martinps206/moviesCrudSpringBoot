package com.martinps.service;

import com.martinps.dao.IGenreRepositoryImplement;
import com.martinps.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService implements IGenreService{

    @Autowired
    private IGenreRepositoryImplement iGenreRepositoryImplement;

    @Override
    public void save(Genre genre) {
        iGenreRepositoryImplement.save(genre);
    }

    @Override
    public Genre findById(Long id) {
        return iGenreRepositoryImplement.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        iGenreRepositoryImplement.deleteById(id);
    }

    @Override
    public List<Genre> findAll() {
        return (List<Genre>) iGenreRepositoryImplement.findAll();
    }
}
