package rooture.com.rooture_server.reportingModule.dao;

import java.util.List;

import rooture.com.rooture_server.reportingModule.dto.ReportDTO;

public interface ReportRepository {
    List<ReportDTO> fetchUserReports();
    List<ReportDTO> fetchListingReports();
    List<ReportDTO> fetchBookingReports();
    List<ReportDTO> fetchPaymentReports();
}
