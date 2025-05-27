package rooture.com.rooture_server.feedbackAndSupportModule.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Feedback {
    private String userId;
    private String listingId;
    private String message;
}
