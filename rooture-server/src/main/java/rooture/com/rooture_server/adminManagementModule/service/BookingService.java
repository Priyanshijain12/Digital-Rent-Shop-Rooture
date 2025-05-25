package rooture.com.rooture_server.adminManagementModule.service;

import java.util.List;

import rooture.com.rooture_server.adminManagementModule.model.Booking;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking updateBooking(Long id, Booking booking);
    void deleteBooking(Long id);
}
