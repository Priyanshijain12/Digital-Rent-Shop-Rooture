package rooture.com.rooture_server.searchAndFilterModule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rooture.com.rooture_server.searchAndFilterModule.dao.ListingRepository;
import rooture.com.rooture_server.searchAndFilterModule.model.Listing;

@Service
public class ListingServiceImpl implements ListingService {

    @Autowired
    private ListingRepository listingRepository;

    @Override
    public List<Listing> searchListings(String location, String type, double price) {
        return listingRepository.findByLocationAndTypeAndPriceLessThanEqual(location, type, price);
    }

    @Override
    public List<Listing> filterListings(String type, double minPrice, double maxPrice, boolean available) {
        return listingRepository.findByTypeAndPriceBetweenAndAvailable(type, minPrice, maxPrice, available);
    }
}
