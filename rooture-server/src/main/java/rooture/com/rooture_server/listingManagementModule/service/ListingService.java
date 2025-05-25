package com.rooture.rentals.service;

import java.util.List;

import com.rooture.rentals.model.Listing;

public interface ListingService {
    void createListing(Listing listing);
    List<Listing> getAllListings();
    void updateListing(Long id, Listing listing);
    void deleteListing(Long id);
}