package com.gymbooking.interfaces;

import com.gymbooking.model.GymClass;

public interface IBookable {

    String getDate();
    String getTime();
    GymClass getGymclass();
}
