package rooture.com.rooture_server.reportingModule.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rooture.com.rooture_server.reportingModule.model.Listing;

public interface ListingRepository extends JpaRepository<Listing, Long> {
}
