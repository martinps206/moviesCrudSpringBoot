package com.martinps.dao;

import com.martinps.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface IMoviesRepositoryImplement extends CrudRepository<Movie, Long> {

}
