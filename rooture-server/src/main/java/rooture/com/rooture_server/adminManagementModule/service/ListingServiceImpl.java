package rooture.com.rooture_server.adminManagementModule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rooture.com.rooture_server.adminManagementModule.dao.ListingRepository;
import rooture.com.rooture_server.adminManagementModule.model.Listing;

import java.util.List;

@Service
public class ListingServiceImpl implements ListingService {

    @Autowired
    private ListingRepository listingRepository;

    public List<Listing> getAllListings() {
        return listingRepository.findAll();
    }

    public Listing updateListing(Long id, Listing listing) {
        Listing existing = listingRepository.findById(id).orElseThrow();
        if (listing.getTitle() == null) throw new RuntimeException("Title required");
        existing.setTitle(listing.getTitle());
        return listingRepository.save(existing);
    }

    public void deleteListing(Long id) {
        listingRepository.deleteById(id);
    }
}
