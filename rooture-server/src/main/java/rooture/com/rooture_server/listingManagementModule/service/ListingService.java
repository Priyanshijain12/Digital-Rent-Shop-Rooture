package rooture.com.rooture_server.listingManagementModule.service;

import java.util.List;

import rooture.com.rooture_server.listingManagementModule.model.Listing;

public interface ListingService {
    void createListing(Listing listing);
    List<Listing> getAllListings();
    void updateListing(Long id, Listing listing);
    void deleteListing(Long id);
}