package rooture.com.rooture_server.adminManagementModule.dao;

import rooture.com.rooture_server.adminManagementModule.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {}
