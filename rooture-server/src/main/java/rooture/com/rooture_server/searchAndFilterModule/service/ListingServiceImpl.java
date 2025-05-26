package rooture.com.rooture_server.searchAndFilterModule.service;

@Service
public class ListingServiceImpl implements ListingService {

    @Autowired
    private ListingRepository listingRepository;

    @Override
    public List<Listing> searchListings(String location, String type, double price) {
        return listingRepository.findByLocationAndTypeAndPriceLessThanEqual(location, type, price);
    }

    @Override
    public List<Listing> filterListings(String type, double minPrice, double maxPrice, boolean available) {
        return listingRepository.findByTypeAndPriceBetweenAndAvailable(type, minPrice, maxPrice, available);
    }
}
