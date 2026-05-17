package com.gymbooking.model;

import com.gymbooking.enums.Role;
import com.gymbooking.util.GymUtils;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "trainers")
public class Trainer extends Person{

    private String speciality;

    public Trainer() {

    }

    public Trainer(String firstname, String lastname, int age, String speciality) {
        super(firstname, lastname, age);
        setSpeciality(speciality);
        setRole(Role.TRAINER);
    }

    public static Trainer of(String firstname, String lastname, int age, String speciality) {
        return new Trainer(firstname, lastname, age, speciality);
    }



    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        if(GymUtils.isNullOrEmpty(speciality)){
            System.out.println("Speciality can not be null");
            return;
        }
        this.speciality = speciality;
    }



    @Override
    public String toString() {
        return "Trainer Information" + "\n" + "Firstname: " + getFirstname() + "\n" + "Lastname: " + getLastname() + "\n" +
                  "Age: " + getAge() + "\n" + "Speciality: " + getSpeciality() ;
    }
}
