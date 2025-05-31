package rooture.com.rooture_server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "listings")
@Data
@Setter
@RequiredArgsConstructor
@Getter
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String type;
    private String location;
    private double price;
    private boolean available;
    private String owner;

    public Object getTitle() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getPrice() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
} 