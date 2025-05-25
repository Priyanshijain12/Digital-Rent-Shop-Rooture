
// --- DAO TEST ---
package com.rooture.repository;

import com.rooture.model.RentalListing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@Import(RentalDAO.class)
public class RentalDAOTest {

    @Autowired
    private RentalDAO rentalDAO;

    @Test
    public void testInsertAndFindRental() {
        RentalListing listing = new RentalListing();
        listing.setTitle("Cozy Room");
        listing.setLocation("Bangalore");
        listing.setPrice(8000);
        listing.setType("room");
        rentalDAO.insertRental(listing);

        List<RentalListing> listings = rentalDAO.findRentalsByLocation("Bangalore");
        assertFalse(listings.isEmpty());
    }
}

// --- SERVICE TEST ---
package com.rooture.service;

        import com.rooture.model.RentalListing;
        import com.rooture.repository.RentalDAO;
        import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.MockitoAnnotations;

        import java.util.Collections;

        import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.*;

public class RentalServiceTest {

    @Mock
    private RentalDAO rentalDAO;

    @InjectMocks
    private RentalService rentalService;

    public RentalServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSearchRentals() {
        when(rentalDAO.findRentalsByLocation("Delhi")).thenReturn(Collections.emptyList());
        assertTrue(rentalService.searchRentals("Delhi").isEmpty());
    }
}

// --- CONTROLLER TEST ---
package rooture.com.rooture_server.rentalManagementModule.controller;

        import com.fasterxml.jackson.databind.ObjectMapper;
        import com.rooture.model.RentalListing;
        import com.rooture.service.RentalService;

import rooture.com.rooture_server.controller.RentalController;

import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
        import org.springframework.boot.test.mock.mockito.MockBean;
        import org.springframework.test.web.servlet.MockMvc;

        import java.util.Collections;

        import static org.mockito.Mockito.*;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
        import static org.springframework.http.MediaType.APPLICATION_JSON;

@WebMvcTest(RentalController.class)
public class RentalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RentalService rentalService;

    @Test
    public void testCreateRental() throws Exception {
        RentalListing listing = new RentalListing();
        listing.setTitle("New Room");
        listing.setLocation("Pune");
        listing.setPrice(9000);
        listing.setType("room");

        ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(post("/api/rentals")
                        .contentType(APPLICATION_JSON)
                        .content(mapper.writeValueAsString(listing)))
                .andExpect(status().isOk())
                .andExpect(content().string("Rental created"));
    }

    @Test
    public void testSearchRentals() throws Exception {
        when(rentalService.searchRentals("Mumbai")).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/api/rentals/search?location=Mumbai"))
                .andExpect(status().isOk());
    }
}
