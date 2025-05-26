package rooture.com.rooture_server.reportingModule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rooture.com.rooture_server.reportingModule.dao.ReportRepository;
import rooture.com.rooture_server.reportingModule.dto.ReportDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    @Override
    public List<ReportDTO> getUserReports() {
        return reportRepository.fetchUserReports();
    }

    @Override
    public List<ReportDTO> getListingReports() {
        return reportRepository.fetchListingReports();
    }

    @Override
    public List<ReportDTO> getBookingReports() {
        return reportRepository.fetchBookingReports();
    }

    @Override
    public List<ReportDTO> getPaymentReports() {
        return reportRepository.fetchPaymentReports();
    }
}
