package rooture.com.rooture_server.reportingModule.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rooture.com.rooture_server.reportingModule.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
