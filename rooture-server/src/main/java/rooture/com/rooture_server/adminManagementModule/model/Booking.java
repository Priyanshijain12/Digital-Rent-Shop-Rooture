package rooture.com.rooture_server.adminManagementModule.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long listingId;
    private String bookedBy;
    private String status;

    public Booking() {}

    public Booking(Long id, Long listingId) {
        this.id = id;
        this.listingId = listingId;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getListingId() { return listingId; }
    public void setListingId(Long listingId) { this.listingId = listingId; }

    public String getBookedBy() { return bookedBy; }
    public void setBookedBy(String bookedBy) { this.bookedBy = bookedBy; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
