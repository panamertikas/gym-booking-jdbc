package com.gymbooking.model;

import com.gymbooking.enums.Role;
import com.gymbooking.util.GymUtils;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstname;
    private String lastname;
    private int age;
    private Role role;

    public Person() {

    }

    public Person(String firstname, String lastname, int age) {
        setFirstname(firstname);
        setLastname(lastname);
        setAge(age);
    }

    public Role getRole() {
        return role;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public void setFirstname(String firstname) {
        if(GymUtils.isNullOrEmpty(firstname)) {
            System.out.println("Name can not be null");
            return;
        }
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {

        if(GymUtils.isNullOrEmpty(lastname)){
            System.out.println("Last name can not be null.");
            return;
        }
        this.lastname = lastname;
    }

    public void setAge(int age) {
        if (!GymUtils.isPositive(age)){
            System.out.println("Invalid age.");
            return;
        }
        this.age = age;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Personal Information" + "\n" + "Firstname: " + firstname + "\n" + "Lastname: " + lastname
                + "\n" + "Age: " + age;
    }
}
