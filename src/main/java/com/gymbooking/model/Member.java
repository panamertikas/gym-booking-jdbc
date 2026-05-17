package com.gymbooking.model;

import com.gymbooking.enums.MembershipType;
import com.gymbooking.enums.Role;
import com.gymbooking.util.GymUtils;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table (name = "members")
public class Member extends Person{

    @Column(unique = true, nullable = false)
    private String mail;

    @Enumerated(EnumType.STRING)
    private MembershipType membershipType;



    // Default and overloaded constructors
    public Member() {}

    public Member(String firstname, String lastname, String mail, int age) {
        super(firstname, lastname, age);
        setMail(mail);
        setRole(Role.MEMBER);

    }

    /**
     * Static factory method to create a new Member instance.
     */
    public static Member of(String firstname, String lastname, String mail, int age) {
        return new Member(firstname, lastname, mail, age);
    }



    // Getters - Setters


    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        if (GymUtils.isNullOrEmpty(mail) || !GymUtils.isValidEmail(mail)) {
            System.out.println("Invalid mail.");
            return;
        }
        this.mail = mail;
    }



//    public void printInfo() {
//        System.out.println("Firstname: " + firstname + "\n" + "Lastname: " + lastname + "\n" +
//                "E-mail : " + mail + "\n" + "Age: " + age + "\n" );
//    }

    @Override
    public String toString() {
        return "Firstname: " + getFirstname()
                + "\n" + "Lastname: " + getLastname() + "\n" +
                "E-mail : " + mail + "\n" + "Age: " + getAge() + "\n" + "Membership Type: " + membershipType ;
    }

    public static class Builder {
        private String firstname;
        private String lastname;
        private String mail;
        private int age;
        private MembershipType membershipType;

        public Builder membershipType(MembershipType membershipType) {
            this.membershipType = membershipType;
            return this;
        }

        public Builder(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public Builder mail(String mail) {
            this.mail = mail;
            return this;
        }

        public Builder age (int age) {
            this.age =age;
            return this;
        }

        public Member build() {
            Member member = new Member(firstname, lastname, mail, age);
            member.setMembershipType(membershipType);
            return member;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Member member)) return false;
        return Objects.equals(mail, member.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mail);
    }
}
