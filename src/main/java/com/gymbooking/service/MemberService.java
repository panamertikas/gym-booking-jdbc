package com.gymbooking.service;


import com.gymbooking.dao.MemberDao;
import com.gymbooking.model.Member;
import com.gymbooking.util.GymUtils;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;


public class MemberService {

    private final MemberDao memberDao;

    public MemberService(EntityManagerFactory emf) {
        this.memberDao = new MemberDao(emf);
    }

    public void addMember(Member member) {
        if (GymUtils.isNull(member)) {
            System.out.println("Invalid member.");
            return;
        }

        memberDao.add(member);
    }

    public void updateMember(Member member) {
        if(GymUtils.isNull(member)) {
            System.out.println("Member cannot be null.");
            return;
        }

        memberDao.update(member);
    }


    public void deleteMember(Member member) {
        if(GymUtils.isNull(member)) {
            System.out.println("Invalid member");
            return;
        }

        memberDao.delete(member);
    }

    public List<Member> getAllMembers() {
        return memberDao.getAll();
    }
}
