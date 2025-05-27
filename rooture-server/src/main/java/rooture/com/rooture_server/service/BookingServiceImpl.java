package rooture.com.rooture_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rooture.com.rooture_server.model.Booking;
import rooture.com.rooture_server.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBooking(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) {
        Booking existing = getBooking(id);
        if (booking.getStatus() != null) {
            existing.setStatus(booking.getStatus());
        }
        if (booking.getStartDate() != null) {
            existing.setStartDate(booking.getStartDate());
        }
        if (booking.getEndDate() != null) {
            existing.setEndDate(booking.getEndDate());
        }
        return bookingRepository.save(existing);
    }

    @Override
    public Booking updateStatus(Long id, String status) {
        Booking booking = getBooking(id);
        booking.setStatus(status);
        return bookingRepository.save(booking);
    }

    @Override
    public String cancelBooking(Long id) {
        Booking booking = getBooking(id);
        booking.setStatus("CANCELLED");
        bookingRepository.save(booking);
        return "Booking cancelled successfully";
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
} 