package rooture.com.rooture_server.reportingModule.service;

import rooture.com.rooture_server.reportingModule.dto.ReportDTO;

import java.util.List;

public interface ReportService {
    List<ReportDTO> getUserReports();
    List<ReportDTO> getListingReports();
    List<ReportDTO> getBookingReports();
    List<ReportDTO> getPaymentReports();
}
