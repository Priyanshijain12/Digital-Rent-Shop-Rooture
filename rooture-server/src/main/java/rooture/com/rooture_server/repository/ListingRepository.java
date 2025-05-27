package rooture.com.rooture_server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rooture.com.rooture_server.model.Listing;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {
    List<Listing> findByLocationAndTypeAndPriceLessThanEqual(String location, String type, double price);
    List<Listing> findByTypeAndPriceBetweenAndAvailable(String type, double minPrice, double maxPrice, boolean available);
} 