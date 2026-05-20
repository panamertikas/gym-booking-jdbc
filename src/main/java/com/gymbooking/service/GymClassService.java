package com.gymbooking.service;

import com.gymbooking.dao.GymClassDao;
import com.gymbooking.model.GymClass;
import com.gymbooking.util.GymUtils;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class GymClassService {

    private final GymClassDao gymClassDao ;

    public GymClassService(EntityManagerFactory emf) {
        this.gymClassDao = new GymClassDao(emf);
    }

    public void addGymClass(GymClass gymClass) {
        if (GymUtils.isNull(gymClass)) {
            System.out.println("Class cannot be null.");
            return;
        }

        gymClassDao.add(gymClass);

    }

    public void updateGymClass(GymClass gymClass) {
        if (GymUtils.isNull(gymClass)) {
            System.out.println("Class cannot be null.");
            return;
        }
        gymClassDao.update(gymClass);
    }

    public void deleteGymClass(GymClass gymClass) {
        if (GymUtils.isNull(gymClass)){
            System.out.println("Class cannot be null.");
            return;
        }

        gymClassDao.delete(gymClass);

    }

    public List<GymClass> getAllGymClasses() {
        return gymClassDao.getAll();
    }


}
