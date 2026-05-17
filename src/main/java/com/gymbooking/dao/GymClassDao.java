package com.gymbooking.dao;

import com.gymbooking.model.GymClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GymClassDao implements IDao<GymClass>{
    private List<GymClass> gymClasses = new ArrayList<>();

    @Override
    public void add(GymClass gymClass) {
        if(gymClasses.contains(gymClass)){
            System.out.println("Gymclass already exists.");
            return;
        }

        gymClasses.add(gymClass);
        System.out.println("GymClass added: " + gymClass.getClassName());
    }

    @Override
    public void update(GymClass gymClass) {

    }

    @Override
    public void delete(GymClass gymClass) {
        gymClasses.remove(gymClass);
        System.out.println("Gym class deleted: " + gymClass.getClassName());
    }

    @Override
    public List<GymClass> getAll() {
        return gymClasses;
    }

    @Override
    public Optional<GymClass> getById(int id) {
        return Optional.empty();
    }
}
