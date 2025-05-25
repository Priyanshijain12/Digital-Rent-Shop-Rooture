package rooture.com.rooture_server.bookingManagementModule.model;

@Entity
@Getters
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

    // Getters and Setters
}