package com.gymbooking;

import com.gymbooking.model.Booking;
import com.gymbooking.model.GymClass;
import com.gymbooking.model.Member;
import com.gymbooking.service.BookingService;
import com.gymbooking.service.GymClassService;
import com.gymbooking.service.MemberService;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gymBookingPU");
        System.out.println("Connection successful!");

        MemberService memberService = new MemberService(emf);

        GymClassService gymClassService = new GymClassService(emf);

        BookingService bookingService = new BookingService(emf);

        Optional<Member> member = memberService.getMemberById(1);
        Optional<GymClass> gymClass = gymClassService.getGymClassById(1);

        // Test add booking
        if (member.isPresent() && gymClass.isPresent()) {
            Booking booking = Booking.of("2024-01-15", "10:00", gymClass.get(), member.get());
            bookingService.addBooking(booking);
        }

        // Test add
        GymClass yoga = GymClass.of("Yoga", "Maria", 10);
        gymClassService.addGymClass(yoga);

        // Test getAll
        List<GymClass> classes = gymClassService.getAllGymClasses();
        classes.forEach(System.out::println);

        // Test update
        Optional<Member> panos = memberService.getMemberById(1);
        panos.ifPresent(m -> {
            m.setFirstname("Panagiotis");
            memberService.updateMember(m);
        });

        // Test getAll
        List<Member> members = memberService.getAllMembers();
        members.forEach(System.out::println);

        emf.close();
    }
}