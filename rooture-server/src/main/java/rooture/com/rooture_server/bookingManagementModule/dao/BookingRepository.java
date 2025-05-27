package rooture.com.rooture_server.bookingManagementModule.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rooture.com.rooture_server.bookingManagementModule.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
