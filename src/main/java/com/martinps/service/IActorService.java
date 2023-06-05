package com.martinps.service;

import com.martinps.entity.Actor;

import java.util.List;

public interface IActorService {

    public void save(Actor actor);
    public Actor findById(Long id);
    public void delete(Long id);
    public List<Actor> findAll();
    public List<Actor> findAllById(List<Long> ids);
}
