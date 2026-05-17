package com.gymbooking.service;

import com.gymbooking.dao.GymClassDao;
import com.gymbooking.dao.MemberDao;
import com.gymbooking.model.GymClass;
import com.gymbooking.util.GymUtils;

import java.util.List;

public class GymClassService {

    private final GymClassDao gymClassDao = new GymClassDao();

    public void addGymClass(GymClass gymClass) {
        if (GymUtils.isNull(gymClass)) {
            System.out.println("Class cannot be null.");
            return;
        }

        gymClassDao.add(gymClass);

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
