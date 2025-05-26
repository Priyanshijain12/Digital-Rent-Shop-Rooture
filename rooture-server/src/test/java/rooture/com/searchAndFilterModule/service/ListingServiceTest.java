package rooture.com.searchAndFilterModule.service;

@ExtendWith(MockitoExtension.class)
public class ListingServiceTest {

    @Mock
    private ListingRepository listingRepository;

    @InjectMocks
    private ListingServiceImpl listingService;

    @Test
    void testSearchListings_shouldReturnMatchingListings() {
        List<Listing> dummyList = List.of(new Listing());
        when(listingRepository.findByLocationAndTypeAndPriceLessThanEqual(any(), any(), anyDouble()))
                .thenReturn(dummyList);
        List<Listing> result = listingService.searchListings("Delhi", "Room", 5000);
        assertEquals(1, result.size());
    }

    @Test
    void testFilterListings_shouldReturnFilteredListings() {
        List<Listing> dummyList = List.of(new Listing());
        when(listingRepository.findByTypeAndPriceBetweenAndAvailable(any(), anyDouble(), anyDouble(), anyBoolean()))
                .thenReturn(dummyList);
        List<Listing> result = listingService.filterListings("Furniture", 1000, 5000, true);
        assertEquals(1, result.size());
    }
}
