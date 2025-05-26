package rooture.com.rooture_server.notificationModule.model;

@Entity
@Getters
@Setters
public class NotificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String recipient;
    private String message;
    private LocalDateTime timestamp;
}
