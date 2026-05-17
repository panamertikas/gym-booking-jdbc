package com.gymbooking.dao;

import com.gymbooking.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberDao  implements IDao<Member> {

    private List<Member> members = new ArrayList<>();

    @Override
    public void add(Member member) {
        if(members.contains(member)) {
            System.out.println("Member already exists.");
            return;
        }
        members.add(member);
        System.out.println("Member added: " + member.getFirstname() );

    }

    @Override
    public void update(Member member) {

    }

    @Override
    public void delete(Member member) {
        members.remove(member);
        System.out.println("Member deleted: " +member.getFirstname());

    }

    @Override
    public List<Member> getAll() {
        return members;
    }

    @Override
    public Optional<Member> getById(int id) {
        return Optional.empty();
    }
}
