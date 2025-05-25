package rooture.com.rooture_server.bookingManagementModule;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingService bookingService;

    @Test
    void createBooking_ShouldReturnSavedBooking() {
        Booking booking = new Booking();
        booking.setStartDate(LocalDate.now());
        booking.setEndDate(LocalDate.now().plusDays(1));

        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        Booking result = bookingService.createBooking(booking);
        assertNotNull(result);
    }

    @Test
    void getBooking_ShouldReturnBooking() {
        Booking booking = new Booking();
        booking.setId(1L);

        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));

        Booking result = bookingService.getBooking(1L);
        assertEquals(1L, result.getId());
    }

    @Test
    void cancelBooking_ShouldSetStatusCancelled() {
        Booking booking = new Booking();
        booking.setId(1L);
        booking.setStatus("Pending");

        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        String result = bookingService.cancelBooking(1L);
        assertEquals("Booking cancelled successfully", result);
    }

    @Test
    void updateStatus_ShouldUpdateBookingStatus() {
        Booking booking = new Booking();
        booking.setId(1L);

        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        Booking result = bookingService.updateStatus(1L, "Confirmed");
        assertEquals("Confirmed", result.getStatus());
    }
}
