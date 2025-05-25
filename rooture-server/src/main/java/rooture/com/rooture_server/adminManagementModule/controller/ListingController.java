package rooture.com.rooture_server.adminManagementModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rooture.com.rooture_server.adminManagementModule.model.Listing;
import rooture.com.rooture_server.adminManagementModule.service.ListingService;

import java.util.List;

@RestController
@RequestMapping("/api/admin/listings")
public class ListingController {

    @Autowired
    private ListingService listingService;

    @GetMapping
    public List<Listing> getAllListings() {
        return listingService.getAllListings();
    }

    @PutMapping("/{id}")
    public Listing updateListing(@PathVariable Long id, @RequestBody Listing listing) {
        if (listing.getTitle() == null) throw new RuntimeException("Title required");
        return listingService.updateListing(id, listing);
    }

    @DeleteMapping("/{id}")
    public void deleteListing(@PathVariable Long id) {
        listingService.deleteListing(id);
    }
}
