package com.martinps.dao;

import com.martinps.entity.Genre;
import org.springframework.data.repository.CrudRepository;

public interface IGenreRepositoryImplement extends CrudRepository<Genre, Long> {


}
