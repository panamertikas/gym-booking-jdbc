package com.gymbooking.dao;

import com.gymbooking.model.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class MemberDao implements IDao<Member> {

    private final EntityManagerFactory emf;

    public MemberDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Adds a new Member to the database.
     * @param member the Member to add
     */
    @Override
    public void add(Member member) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(member);
            em.getTransaction().commit();
            System.out.println("Member added: " + member.getFirstname());
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error adding member: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Updates a new Member to the database.
     * @param member the Member to update
     */
    @Override
    public void update(Member member) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(member);
            em.getTransaction().commit();
            System.out.println("Member updated: " + member.getFirstname());
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error updating member: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Removes a new Member from the database.
     * @param member the Member to remove
     */
    @Override
    public void delete(Member member) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Member managed = em.merge(member);
            em.remove(managed);
            em.getTransaction().commit();
            System.out.println("Member deleted: " + member.getFirstname());
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error deleting member: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Returns all Members from the database
     * @return list of all Members.
     */
    @Override
    public List<Member> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m", Member.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Returns a Member by its id.
     * @param id the id of the Member
     * @return Optional containing the Member if found, empty otherwise
     */
    @Override
    public Optional<Member> getById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Member member = em.find(Member.class, (long) id);
            return Optional.ofNullable(member);
        } finally {
            em.close();
        }
    }
}