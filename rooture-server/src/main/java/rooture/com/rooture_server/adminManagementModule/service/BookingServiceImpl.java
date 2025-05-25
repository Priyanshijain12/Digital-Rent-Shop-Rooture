package rooture.com.rooture_server.adminManagementModule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rooture.com.rooture_server.adminManagementModule.dao.BookingRepository;
import rooture.com.rooture_server.adminManagementModule.model.Booking;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking updateBooking(Long id, Booking booking) {
        Booking existing = bookingRepository.findById(id).orElseThrow();
        if (booking.getStatus() == null) throw new RuntimeException("Status required");
        existing.setStatus(booking.getStatus());
        return bookingRepository.save(existing);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
