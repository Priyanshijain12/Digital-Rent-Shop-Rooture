package rooture.com.rooture_server.feedbackAndSupportModule.controller;

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
