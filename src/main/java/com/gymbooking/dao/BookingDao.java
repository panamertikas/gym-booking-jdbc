package com.gymbooking.dao;

import com.gymbooking.model.Booking;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingDao implements IDao<Booking> {

    private final EntityManagerFactory emf;

    public BookingDao(EntityManagerFactory emf) {
        this.emf = emf;
    }


    /**
     * Adds a new Booking to the database.
     * @param booking the Booking to add
     */
    @Override
    public void add(Booking booking) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(booking);
            em.getTransaction().commit();
            System.out.println("Booking added successfully: " + booking.getMember().getFirstname());
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error adding booking: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Updates a Booking to the database.
     * @param booking the Booking to update
     */
    @Override
    public void update(Booking booking) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(booking);
            em.getTransaction().commit();
            System.out.println("Booking updated successfully: " + booking.getMember().getFirstname());
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error updating booking: " + e.getMessage());
        } finally {
            em.close();
        }
    }


    /**
     * Removes a Booking from the database
     * @param booking the Booking to remove
     */
    @Override
    public void delete(Booking booking) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Booking managed = em.merge(booking);
            em.remove(managed);
            em.getTransaction().commit();
            System.out.println("Booking removed successfully: " + booking.getMember().getFirstname());
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error deleting booking: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Returns all Bookings from the database
     * @return list of all Bookings.
     */
    @Override
    public List<Booking> getAll() {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Booking> query = em.createQuery("SELECT b FROM Booking b", Booking.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Returns a Booking by its id.
     * @param id the id of the Booking
     * @return Optional containing the Booking if found, empty otherwise
     */
    @Override
    public Optional<Booking> getById(int id) {

        EntityManager em = emf.createEntityManager();

        try {
            Booking booking = em.find(Booking.class,(long) id);
            return Optional.ofNullable(booking);
        } finally {
            em.close();
        }
    }
}
