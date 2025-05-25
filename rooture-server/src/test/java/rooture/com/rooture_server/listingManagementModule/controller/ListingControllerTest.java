package com.rooture.rentals.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import rooture.com.rooture_server.listingManagementModule.model.Listing;
import rooture.com.rooture_server.listingManagementModule.service.ListingService;

public class ListingControllerTest {

    @InjectMocks
    private ListingController listingController;

    @Mock
    private ListingService listingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createListing_withValidData_returnsSuccessMessage() {
        Listing dummy = new Listing();
        dummy.setTitle("Test Listing");
        dummy.setPrice(1000);
        ResponseEntity<String> response = listingController.createListing(dummy);
        assertEquals("Listing created successfully", response.getBody());
    }

    @Test
    void getAllListings_returnsEmptyListWhenNoData() {
        when(listingService.getAllListings()).thenReturn(Collections.emptyList());
        ResponseEntity<?> response = listingController.getAllListings();
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void updateListing_withValidId_returnsSuccess() {
        Listing dummy = new Listing();
        dummy.setTitle("Updated");
        ResponseEntity<String> response = listingController.updateListing(1L, dummy);
        assertEquals("Listing updated successfully", response.getBody());
    }

    @Test
    void deleteListing_returnsSuccess() {
        ResponseEntity<String> response = listingController.deleteListing(1L);
        assertEquals("Listing deleted successfully", response.getBody());
    }
}