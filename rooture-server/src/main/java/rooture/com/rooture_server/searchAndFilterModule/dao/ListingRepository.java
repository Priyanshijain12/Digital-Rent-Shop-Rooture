package rooture.com.rooture_server.searchAndFilterModule.dao;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {
    List<Listing> findByLocationAndTypeAndPriceLessThanEqual(String location, String type, double price);
    List<Listing> findByTypeAndPriceBetweenAndAvailable(String type, double minPrice, double maxPrice, boolean available);
}
