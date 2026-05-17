package com.gymbooking.model;

import com.gymbooking.interfaces.IBookable;
import com.gymbooking.util.GymUtils;
import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking implements IBookable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String time;

    @ManyToOne
    @JoinColumn(name = "gym_class_id", nullable = false)
    private GymClass gymclass;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    public Booking() {}

    public Booking(String date, String time, GymClass gymclass, Member member) {
        setDate(date);
        setTime(time);
        setGymclass(gymclass);
        setMember(member);
    }

    public static Booking of (String date, String time, GymClass gymclass, Member member) {
        return new Booking(date, time, gymclass, member);
    }

    @Override
    public String getDate() {
        return date;
    }

    public void setDate(String date) {

        if(GymUtils.isNullOrEmpty(date)) {
            System.out.println("Invalid date.");
            return;
        }
        this.date = date;
    }

    @Override
    public String getTime() {
        return time;
    }

    public void setTime(String time) {

        if(GymUtils.isNullOrEmpty(time)){
            System.out.println("Invalid time.");
            return;
        }
        this.time = time;
    }

    @Override
    public GymClass getGymclass() {
        return gymclass;
    }

    public void setGymclass(GymClass gymclass) {
        if(GymUtils.isNull(gymclass)){
            System.out.println("Gym class cannot be null.");
            return;
        }
        this.gymclass = gymclass;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        if (GymUtils.isNull(member)) {
            System.out.println("Member can not be null");
            return;
        }
        this.member = member;
    }

    @Override
    public String toString() {
        return "Your Booking" + "\n" +
                "Member: " + getMember().getFirstname() + " " + getMember().getLastname() + "\n" +
                "Class: " + getGymclass().getClassName() + "\n" +
                "Date: " + getDate() + "\n" +
                "Time: " + getTime();
    }
}
