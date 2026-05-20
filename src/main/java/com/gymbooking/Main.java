package com.gymbooking;

import com.gymbooking.model.Member;
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