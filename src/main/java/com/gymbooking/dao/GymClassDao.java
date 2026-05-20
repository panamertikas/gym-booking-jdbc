package com.gymbooking.dao;

import com.gymbooking.model.GymClass;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GymClassDao implements IDao<GymClass>{


    private final EntityManagerFactory emf;

    public GymClassDao(EntityManagerFactory emf) {
        this.emf =emf;
    }


    /**
     * Adds a new GymClass to the database.
     * @param gymClass the GymClass to add
     */
    @Override
    public void add(GymClass gymClass) {
       EntityManager em = emf.createEntityManager();
       try{
           em.getTransaction().begin();
           em.persist(gymClass);
           em.getTransaction().commit();
           System.out.println("Gymclass added: " + gymClass.getClassName());
       } catch (Exception e) {
           em.getTransaction().rollback();
           System.out.println("Error adding gym class: " + e.getMessage());
       } finally {
           em.close();
       }
    }

    /**
     * Updates a new GymClass to the database.
     * @param gymClass the GymClass to update
     */
    @Override
    public void update(GymClass gymClass) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(gymClass);
            em.getTransaction().commit();
            System.out.println("Gym class updated successfully: " + gymClass.getClassName());
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error updating gym class: " + e.getMessage());
        } finally {
            em.close();
        }

    }

    /**
     * Removes a new GymClass from the database.
     * @param gymClass the GymClass to remove
     */
    @Override
    public void delete(GymClass gymClass) {
       EntityManager em = emf.createEntityManager();
       try {
           em.getTransaction().begin();
           GymClass managed = em.merge(gymClass);
           em.remove(managed);
           em.getTransaction().commit();
           System.out.println("Gym class deleted successfully: " + gymClass.getClassName());
       } catch (Exception e) {
           em.getTransaction().rollback();
           System.out.println("Error deleting gym class: " + e.getMessage());
       } finally {
           em.close();
       }
    }

    /**
     * Returns all GymClasses from the database.
     * @return list of all GymClasses
     */
    @Override
    public List<GymClass> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<GymClass> query = em.createQuery("SELECT g FROM GymClass g", GymClass.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Returns a GymClass by its id.
     * @param id the id of the GymClass
     * @return Optional containing the GymClass if found, empty otherwise
     */
    @Override
    public Optional<GymClass> getById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            GymClass gymClass = em.find(GymClass.class, (long) id);
            return Optional.ofNullable(gymClass);
        } finally {
            em.close();
        }
    }
}
