package com.gymbooking.model;

public class GymManager {

    private static GymManager instance;
    private String name;

    private  GymManager(String name) {
        this.name = name;
    }

    public static GymManager getInstance(String name) {
        if(instance == null) {
            instance = new GymManager(name) ;
        }
        return instance;
    }

    public static GymManager getInstance() {
        return instance;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Gym Manager: " + name;
    }
}
