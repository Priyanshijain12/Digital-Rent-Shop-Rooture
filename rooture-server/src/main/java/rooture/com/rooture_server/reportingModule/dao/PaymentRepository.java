package rooture.com.rooture_server.reportingModule.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rooture.com.rooture_server.reportingModule.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
