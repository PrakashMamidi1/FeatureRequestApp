package com.example.demo.service;

import com.example.demo.data.FeatureRepository;
import com.example.demo.model.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeatureService {


    @Autowired
    private FeatureRepository repo;

    // will retrieve all articles stored
    public List<Feature> getAll() {


        return repo.findAll(Sort.by(Sort.Direction.ASC, "client").and(Sort.by(Sort.Direction.ASC, "priority").and(Sort.by(Sort.Direction.DESC, "createDate"))));
    }

    // will use the id to find an article with the same id
    // if none is found, it will return null
    public Optional<Feature> findById(int id) {


        return repo.findById(id);
    }

    // stores a new article and assigns it a unique id
    public Feature add(Feature feature) {
        feature.setCreateDate(new Date());
        return repo.save(feature);


    }

    // removes an article by its id
    public void remove(int id) {
        repo.deleteById(id);
    }

    // takes an updated article and stores it
    public Feature update(Feature updated) {

        updated.setCreateDate(new Date());

        return repo.save(updated);
    }

    public List<Feature> findByTitle(String title) {
        return getAll()
                .stream()
                .filter(f -> f.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());

    }
}