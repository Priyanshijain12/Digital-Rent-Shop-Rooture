package rooture.com.rooture_server.notificationModule.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsRequest {
    private String phoneNumber;
    private String message;
}
