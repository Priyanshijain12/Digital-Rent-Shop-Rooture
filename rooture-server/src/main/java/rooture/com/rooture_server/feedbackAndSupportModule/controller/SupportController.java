package rooture.com.rooture_server.feedbackAndSupportModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rooture.com.rooture_server.feedbackAndSupportModule.model.SupportQuery;
import rooture.com.rooture_server.feedbackAndSupportModule.service.SupportService;

@RestController
@RequestMapping("/api/support")
public class SupportController {

    @Autowired
    private SupportService supportService;

    @PostMapping("/contact")
    public ResponseEntity<String> contactSupport(@RequestBody SupportQuery query) {
        if (query.getSubject().isEmpty()) {
            return ResponseEntity.badRequest().body("Subject is required");
        }
        return ResponseEntity.ok(supportService.submitQuery(query));
    }
}
