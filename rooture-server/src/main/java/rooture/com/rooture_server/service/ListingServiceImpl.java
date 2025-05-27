package rooture.com.rooture_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rooture.com.rooture_server.model.Listing;
import rooture.com.rooture_server.repository.ListingRepository;

@Service
public class ListingServiceImpl implements ListingService {

    @Autowired
    private ListingRepository listingRepository;

    @Override
    public void createListing(Listing listing) {
        listingRepository.save(listing);
    }

    @Override
    public List<Listing> getAllListings() {
        return listingRepository.findAll();
    }

    @Override
    public void updateListing(Long id, Listing listing) {
        listing.setId(id);
        listingRepository.save(listing);
    }

    @Override
    public void deleteListing(Long id) {
        listingRepository.deleteById(id);
    }

    @Override
    public List<Listing> searchListings(String location, String type, double price) {
        return listingRepository.findByLocationAndTypeAndPriceLessThanEqual(location, type, price);
    }

    @Override
    public List<Listing> filterListings(String type, double minPrice, double maxPrice, boolean available) {
        return listingRepository.findByTypeAndPriceBetweenAndAvailable(type, minPrice, maxPrice, available);
    }
} 