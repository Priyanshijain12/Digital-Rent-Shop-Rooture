package rooture.com.rooture_server.reportingModule.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import rooture.com.rooture_server.reportingModule.dto.ReportDTO;

@Repository
@RequiredArgsConstructor
public class ReportRepositoryImpl implements ReportRepository {

    private final UserRepository userRepository;
    private final ListingRepository listingRepository;
    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public List<ReportDTO> fetchUserReports() {
        long totalUsers = userRepository.count();
        return null;
    }

    @Override
    public List<ReportDTO> fetchListingReports() {
        long totalListings = listingRepository.count();
        return null;
    }

    @Override
    public List<ReportDTO> fetchBookingReports() {
        long totalBookings = bookingRepository.count();
        return null;
    }

    @Override
    public List<ReportDTO> fetchPaymentReports() {
        double totalPayments = paymentRepository.findAll().stream().mapToDouble(p -> p.getAmount()).sum();
        return null;
    }
}
