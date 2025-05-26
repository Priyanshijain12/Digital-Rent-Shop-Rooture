package rooture.com.rooture_server.searchAndFilterModule.controller;

@RestController
@RequestMapping("/api/listings")
public class ListingController {

    @Autowired
    private ListingService listingService;

    @GetMapping("/search")
    public ResponseEntity<List<Listing>> searchListings(
        @RequestParam String location,
        @RequestParam String type,
        @RequestParam double price
    ) {
        return ResponseEntity.ok(listingService.searchListings(location, type, price));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Listing>> filterListings(
        @RequestParam String type,
        @RequestParam double minPrice,
        @RequestParam double maxPrice,
        @RequestParam boolean available
    ) {
        return ResponseEntity.ok(listingService.filterListings(type, minPrice, maxPrice, available));
    }
}

