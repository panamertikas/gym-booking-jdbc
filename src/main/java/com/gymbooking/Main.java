package com.gymbooking;

import com.gymbooking.model.Member;
import com.gymbooking.service.MemberService;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gymBookingPU");
        System.out.println("Connection successful!");


        MemberService memberService = new MemberService(emf);

        Member m1 = Member.of("Panos", "Mertikas", "panos@gmail.com", 25);
        memberService.addMember(m1);

        List<Member> members = memberService.getAllMembers();
        members.forEach(System.out::println);

        emf.close();
    }
}