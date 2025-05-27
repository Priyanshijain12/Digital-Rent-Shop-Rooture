package rooture.com.rooture_server.searchAndFilterModule.service;

import java.util.List;

import rooture.com.rooture_server.searchAndFilterModule.model.Listing;

public interface ListingService {
    List<Listing> searchListings(String location, String type, double price);
    List<Listing> filterListings(String type, double minPrice, double maxPrice, boolean available);
}

