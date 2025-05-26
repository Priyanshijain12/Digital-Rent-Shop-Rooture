package rooture.com.rooture_server.searchAndFilterModule.service;

public interface ListingService {
    List<Listing> searchListings(String location, String type, double price);
    List<Listing> filterListings(String type, double minPrice, double maxPrice, boolean available);
}

