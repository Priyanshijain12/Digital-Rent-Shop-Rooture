package rooture.com.rooture_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rooture.com.rooture_server.model.RentalListing;
import rooture.com.rooture_server.service.RentalService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*") // allow frontend to access APIs, adjust as needed
public class AdminController {

    @Autowired
private RentalService rentalService;

// POST: /api/admin
@PostMapping
public ResponseEntity<String> createRental(@RequestBody RentalListing rental) {
    rentalService.createRental(rental);
    return ResponseEntity.ok("Rental created successfully.");
}

// PUT: /api/admin/{id}
@PutMapping("/{id}")
public ResponseEntity<String> updateRental(@PathVariable int id, @RequestBody RentalListing rental) {
    rental.setId(id);
    rentalService.updateRental(rental);
    return ResponseEntity.ok("Rental updated successfully.");
}

// GET: /api/admin/search?location={location}
@GetMapping("/search")
public ResponseEntity<List<RentalListing>> searchRentals(@RequestParam String location) {
    List<RentalListing> listings = rentalService.searchRentals(location);
    return ResponseEntity.ok(listings);
}

// GET: /api/admin/book?listingId=1&tenantId=2
@GetMapping("/book")
public ResponseEntity<String> bookRental(@RequestParam int listingId, @RequestParam int tenantId) {
    rentalService.bookRental(listingId, tenantId);
    return ResponseEntity.ok("Rental booked successfully.");
}

// POST: /api/admin/agreement?listingId=1&tenantId=2
@PostMapping("/agreement")
public ResponseEntity<String> createAgreement(@RequestParam int listingId, @RequestParam int tenantId) {
    rentalService.createRentalAgreement(listingId, tenantId);
    return ResponseEntity.ok("Rental agreement created successfully.");
}

// GET: /api/admin/report
@GetMapping("/report")
public ResponseEntity<String> getReport() {
    String report = rentalService.generateReport();
    return ResponseEntity.ok(report);
}

}