package rooture.com.rooture_server.searchAndFilterModule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rooture.com.rooture_server.searchAndFilterModule.model.Listing;
import rooture.com.rooture_server.searchAndFilterModule.service.ListingService;

@RestController
@RequestMapping("/api/listings")
public class ListingController {

    @Autowired
    private ListingService listingService;

    @GetMapping("/search")
    public ResponseEntity<List<Listing>> searchListings(
        @RequestParam String location,
        @RequestParam String type,
        @RequestParam double price
    ) {
        return ResponseEntity.ok(listingService.searchListings(location, type, price));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Listing>> filterListings(
        @RequestParam String type,
        @RequestParam double minPrice,
        @RequestParam double maxPrice,
        @RequestParam boolean available
    ) {
        return ResponseEntity.ok(listingService.filterListings(type, minPrice, maxPrice, available));
    }
}

