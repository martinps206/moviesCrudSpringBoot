package com.martinps.dao;

import com.martinps.entity.Actor;
import org.springframework.data.repository.CrudRepository;

public interface IActorRepositoryImplement extends CrudRepository<Actor, Long> {
}
