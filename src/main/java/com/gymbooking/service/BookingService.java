package com.gymbooking.service;

import com.gymbooking.dao.BookingDao;
import com.gymbooking.model.Booking;
import com.gymbooking.util.GymUtils;

import java.util.List;

public class BookingService {

    private final BookingDao bookingDao = new BookingDao();

    public void addBooking(Booking booking) {
        if(GymUtils.isNull(booking)) {
            System.out.println("Invalid booking.");
            return;
        }

        bookingDao.add(booking);

    }

    public void deleteBooking(Booking booking) {
        if(GymUtils.isNull(booking)) {
            System.out.println("Invalid booking.");
            return;
        }

        bookingDao.delete(booking);

    }

    public List<Booking> getAllBookings() {
        return bookingDao.getAll();
    }
}
