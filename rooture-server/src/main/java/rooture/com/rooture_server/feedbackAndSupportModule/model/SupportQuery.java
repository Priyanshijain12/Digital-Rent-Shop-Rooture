package rooture.com.rooture_server.feedbackAndSupportModule.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupportQuery {
    private String userId;
    private String subject;
    private String description;
}
