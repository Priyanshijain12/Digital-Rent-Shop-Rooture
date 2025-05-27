package rooture.com.rooture_server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rooture.com.rooture_server.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByBookedBy(String bookedBy);
    List<Booking> findByListingId(Long listingId);
} 