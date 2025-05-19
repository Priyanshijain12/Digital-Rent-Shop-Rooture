
import com.rooture.model.RentalListing;
import com.rooture.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin") // api/admin/createRental
public class AdminController {

    @Autowired
    private RentalService rentalService;

    @PostMapping
    public ResponseEntity<String> createRental(@RequestBody RentalListing rental) {
        rentalService.createRental(rental);
        return ResponseEntity.ok("Rental created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRental(@PathVariable int id, @RequestBody RentalListing rental) {
        rental.setId(id);
        rentalService.updateRental(rental);
        return ResponseEntity.ok("Rental updated");
    }

    @GetMapping("/search")
    public ResponseEntity<List<RentalListing>> searchRentals(@RequestParam String location) {
        return ResponseEntity.ok(rentalService.searchRentals(location));
    }

    @GetMapping("/book")
    public ResponseEntity<String> bookRental(@RequestParam int listingId, @RequestParam int tenantId) {
        rentalService.bookRental(listingId, tenantId);
        return ResponseEntity.ok("Rental booked");
    }

    @PostMapping("/agreement")
    public ResponseEntity<String> createAgreement(@RequestParam int listingId, @RequestParam int tenantId) {
        rentalService.createRentalAgreement(listingId, tenantId);
        return ResponseEntity.ok("Agreement created");
    }

    @GetMapping("/report")
    public ResponseEntity<String> getReport() {
        return ResponseEntity.ok(rentalService.generateReport());
    }
}