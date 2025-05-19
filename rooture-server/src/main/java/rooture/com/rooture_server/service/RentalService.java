package com.rooture.service;

import com.rooture.model.RentalListing;
import com.rooture.repository.RentalDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalDAO rentalDAO;

    public void createRental(RentalListing rental) {
        rentalDAO.insertRental(rental);
    }

    public void updateRental(RentalListing rental) {
        rentalDAO.updateRental(rental);
    }

    public List<RentalListing> searchRentals(String location) {
        return rentalDAO.findRentalsByLocation(location);
    }

    public void bookRental(int listingId, int tenantId) {
        rentalDAO.bookRental(listingId, tenantId);
    }

    public void createRentalAgreement(int listingId, int tenantId) {
        rentalDAO.createAgreement(listingId, tenantId);
    }

    public String generateReport() {
        return rentalDAO.generateReport();
    }
}