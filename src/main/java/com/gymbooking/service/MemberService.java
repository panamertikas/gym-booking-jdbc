package com.gymbooking.service;

import com.gymbooking.dao.MemberDao;
import com.gymbooking.model.Member;
import com.gymbooking.util.GymUtils;

import java.util.List;
import java.util.Objects;

public class MemberService {

    private final MemberDao memberDao = new MemberDao();

    public void addMember(Member member) {
        if (GymUtils.isNull(member)) {
            System.out.println("Invalid member.");
            return;
        }

        memberDao.add(member);
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
