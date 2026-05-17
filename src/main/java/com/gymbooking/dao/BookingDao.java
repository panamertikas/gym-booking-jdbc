package com.gymbooking.dao;

import com.gymbooking.model.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingDao implements IDao<Booking> {
    private List<Booking> bookings = new ArrayList<>();

    @Override
    public void add(Booking booking) {
        if(bookings.contains(booking)){
            System.out.println("Booking already exists.");
            return;
        }
        bookings.add(booking);
        System.out.println("Booking added: " + booking.getMember().getFirstname());
    }

    @Override
    public void update(Booking booking) {

    }

    @Override
    public void delete(Booking booking) {
        bookings.remove(booking);
        System.out.println("Booking deleted: " + booking.getMember().getFirstname());
    }

    @Override
    public List<Booking> getAll() {
        return bookings;
    }

    @Override
    public Optional<Booking> getById(int id) {
        return Optional.empty();
    }
}
