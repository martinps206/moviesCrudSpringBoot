package com.martinps.dao;

import com.martinps.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;

public interface IMoviesRepositoryImplement extends JpaRepository<Movie, Long> {

}
