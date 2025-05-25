package rooture.com.rooture_server.bookingManagementModule.controller;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBooking(id));
    }

    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.cancelBooking(id));
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Booking> updateBookingStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(bookingService.updateStatus(id, status));
    }
}
