package rooture.com.rooture_server.searchAndFilterModule.model;

@Entity
@Getters
@Setters

public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private String type;
    private double price;
    private boolean available;
}

