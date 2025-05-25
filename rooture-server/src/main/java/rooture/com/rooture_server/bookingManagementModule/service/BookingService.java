package rooture.com.rooture_server.bookingManagementModule.service;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(Booking booking) {
        if (booking.getStartDate().isAfter(booking.getEndDate())) {
            throw new IllegalArgumentException("Start date must be before end date");
        }
        booking.setStatus("Pending");
        return bookingRepository.save(booking);
    }

    public Booking getBooking(Long id) {
        return bookingRepository.findById(id).orElseThrow();
    }

    public String cancelBooking(Long id) {
        Booking booking = getBooking(id);
        booking.setStatus("Cancelled");
        bookingRepository.save(booking);
        return "Booking cancelled successfully";
    }

    public Booking updateStatus(Long id, String status) {
        Booking booking = getBooking(id);
        booking.setStatus(status);
        return bookingRepository.save(booking);
    }
}
