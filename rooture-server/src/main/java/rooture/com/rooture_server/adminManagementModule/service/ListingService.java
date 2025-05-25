package rooture.com.rooture_server.adminManagementModule.service;

import java.util.List;

import rooture.com.rooture_server.adminManagementModule.model.Listing;

public interface ListingService {
    List<Listing> getAllListings();
    Listing updateListing(Long id, Listing listing);
    void deleteListing(Long id);
}
