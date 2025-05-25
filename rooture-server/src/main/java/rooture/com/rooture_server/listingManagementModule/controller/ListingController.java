package com.rooture.rentals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rooture.com.rooture_server.listingManagementModule.model.Listing;
import rooture.com.rooture_server.listingManagementModule.service.ListingService;

@RestController
@RequestMapping("/api/listings")
public class ListingController {

    @Autowired
    private ListingService listingService; 

    @PostMapping
    public ResponseEntity<String> createListing(@RequestBody Listing listing) {
        if (listing.getTitle() == null || listing.getPrice() <= 0) return ResponseEntity.badRequest().body("Invalid listing");
        listingService.createListing(listing);
        return ResponseEntity.ok("Listing created successfully");
    }

    @GetMapping
    public ResponseEntity<List<Listing>> getAllListings() {
        return ResponseEntity.ok(listingService.getAllListings());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateListing(@PathVariable Long id, @RequestBody Listing updatedListing) {
        if (updatedListing.getTitle() == null) return ResponseEntity.badRequest().body("Invalid data");
        listingService.updateListing(id, updatedListing);
        return ResponseEntity.ok("Listing updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteListing(@PathVariable Long id) {
        listingService.deleteListing(id);
        return ResponseEntity.ok("Listing deleted successfully");
    }
}
