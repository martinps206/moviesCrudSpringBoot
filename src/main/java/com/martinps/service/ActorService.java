package com.martinps.service;

import com.martinps.dao.IActorRepositoryImplement;
import com.martinps.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService{

    @Autowired
    private IActorRepositoryImplement iActorRepositoryImplement;
    @Override
    public void save(Actor actor) {
        iActorRepositoryImplement.save(actor);
    }

    @Override
    public Actor findById(Long id) {
        return iActorRepositoryImplement.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        iActorRepositoryImplement.deleteById(id);
    }

    @Override
    public List<Actor> findAll() {
        return (List<Actor>) iActorRepositoryImplement.findAll();
    }

    @Override
    public List<Actor> findAllById(List<Long> ids) {
        return (List<Actor>) iActorRepositoryImplement.findAllById(ids);
    }
}
