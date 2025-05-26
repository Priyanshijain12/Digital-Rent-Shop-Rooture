package rooture.com.rooture_server.reportingModule.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import rooture.com.rooture_server.reportingModule.dto.ReportDTO;

import java.util.List;

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
        return List.of(new ReportDTO("Total Users", String.valueOf(totalUsers)));
    }

    @Override
    public List<ReportDTO> fetchListingReports() {
        long totalListings = listingRepository.count();
        return List.of(new ReportDTO("Total Listings", String.valueOf(totalListings)));
    }

    @Override
    public List<ReportDTO> fetchBookingReports() {
        long totalBookings = bookingRepository.count();
        return List.of(new ReportDTO("Total Bookings", String.valueOf(totalBookings)));
    }

    @Override
    public List<ReportDTO> fetchPaymentReports() {
        double totalPayments = paymentRepository.findAll().stream().mapToDouble(p -> p.getAmount()).sum();
        return List.of(new ReportDTO("Total Payments", "$" + totalPayments));
    }
}
