package rooture.com.rooture_server.reportingModule.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
// @NoArgsConstructor
@Getter
@Setter
public class ReportDTO {
    private String title;
    private String value;
    private Double amount;
}
