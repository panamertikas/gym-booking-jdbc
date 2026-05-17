package com.gymbooking.model;

import com.gymbooking.exceptions.GymClassEmptyException;
import com.gymbooking.exceptions.GymClassFullException;
import com.gymbooking.util.GymUtils;
import jakarta.persistence.*;

@Entity
@Table (name = "gym_classes")
public class GymClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "class_name", nullable = false)
    private String className;

    @Column(nullable = false)
    private String trainer;

    @Column(name = "max_Capacity", nullable = false)
    private int maxCapacity;

    @Column(name = "current_capacity")
    private int currentCapacity;

    private static int classCount = 0;

    public GymClass() {
        classCount++;
    }

    public GymClass(String className, String trainer, int maxCapacity) {
        setClassName(className);
        setTrainer(trainer);
        setMaxCapacity(maxCapacity);
        classCount++;
    }

    /**
     * Static factory method to create a new GymClass instance.
     */
    public static GymClass of(String className, String trainer, int maxCapacity) {
        return new GymClass(className, trainer, maxCapacity);
    }

    public static int getClassCount() {
        return classCount;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        if (GymUtils.isNullOrEmpty(className)) {
            System.out.println("Class name can not be null.");
            return;
        }
        this.className = className;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        if (GymUtils.isNullOrEmpty(trainer)) {
            System.out.println("Trainer name can not be null.");
            return;
        }
        this.trainer = trainer;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        if (!GymUtils.isPositive(maxCapacity)) {
            System.out.println("Invalid max capacity.");
            return;
        }
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

//    public void setCurrentCapacity(int currentCapacity) {
//        if (currentCapacity < 0) {
//            System.out.println("Invalid current capacity.");
//            return;
//        }
//        if  (currentCapacity > maxCapacity){
//            System.out.println("Current capacity can not exceed max capacity.");
//            return;
//        }
//        this.currentCapacity = currentCapacity;
//    }

//    public void printInfo() {
//        System.out.println("Class name: " + className + "\n" + "Trainer: " + trainer + "\n" +
//                "Max Capacity: " + maxCapacity + "\n" + "Current Capacity: " + currentCapacity + "\n");
//    }

    @Override
    public String toString() {
        return "Class name: " + className + "\n" + "Trainer: " + trainer + "\n" +
                "Max Capacity: " + maxCapacity + "\n" + "Current Capacity: " + currentCapacity + "\n";
    }

    /**
     * Adds a member to the class.
     * Fails if the class is already full.
     */
    public void addMember() throws GymClassFullException {
        if (currentCapacity >= maxCapacity) {
            throw new GymClassFullException("Class " + className + " is full.");
        }

        currentCapacity++;
        System.out.println("Member added. Current capacity: " + currentCapacity);
    }


    /**
     * Removes a member from the class.
     * Fails if the class is empty.
     */
    public void removeMember() throws GymClassEmptyException {
        if (currentCapacity <= 0) {
            throw new GymClassEmptyException("Class " + className + " is empty.");
        }

        currentCapacity--;
        System.out.println("Member removed. Current capacity: " +currentCapacity);
    }

    /**
     * Returns true if the class has reached max capacity.
     */
    public boolean isFull() {
        return currentCapacity >= maxCapacity;
    }
}
