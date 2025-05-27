package rooture.com.rooture_server.listingManagementModule.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rooture.com.rooture_server.listingManagementModule.model.Listing;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {
} 