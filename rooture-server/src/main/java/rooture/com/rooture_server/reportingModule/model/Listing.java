package rooture.com.rooture_server.reportingModule.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "listings")
@Data
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String type;
    private String location;
    private double price;
}
