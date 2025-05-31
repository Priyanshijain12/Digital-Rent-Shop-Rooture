package rooture.com.rooture_server.bookingManagementModule.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long listingId;
    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    public void setEndDate(LocalDate plusDays) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setStartDate(LocalDate now) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setId(long l) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object getStatus() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setStatus(String pending) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public long getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}