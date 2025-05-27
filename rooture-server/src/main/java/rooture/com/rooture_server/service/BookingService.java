package rooture.com.rooture_server.service;

import java.util.List;

import rooture.com.rooture_server.model.Booking;

public interface BookingService {
    Booking createBooking(Booking booking);
    List<Booking> getAllBookings();
    Booking getBooking(Long id);
    Booking updateBooking(Long id, Booking booking);
    Booking updateStatus(Long id, String status);
    String cancelBooking(Long id);
    void deleteBooking(Long id);
} 