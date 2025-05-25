package rooture.com.rooture_server.adminManagementModule.dao;

import rooture.com.rooture_server.adminManagementModule.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {}
