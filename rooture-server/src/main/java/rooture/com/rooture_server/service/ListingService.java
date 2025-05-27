package rooture.com.rooture_server.service;

import java.util.List;

import rooture.com.rooture_server.model.Listing;

public interface ListingService {
    void createListing(Listing listing);
    List<Listing> getAllListings();
    void updateListing(Long id, Listing listing);
    void deleteListing(Long id);
    List<Listing> searchListings(String location, String type, double price);
    List<Listing> filterListings(String type, double minPrice, double maxPrice, boolean available);
} 