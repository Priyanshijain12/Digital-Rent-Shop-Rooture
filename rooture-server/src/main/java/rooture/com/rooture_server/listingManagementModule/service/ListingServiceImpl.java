package com.rooture.rentals.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rooture.rentals.dao.ListingDao;
import com.rooture.rentals.model.Listing;

@Service
public class ListingServiceImpl implements ListingService {

    @Autowired
    private ListingDao listingDao;

    @Override
    public void createListing(Listing listing) {
        listingDao.save(listing);
    }

    @Override
    public List<Listing> getAllListings() {
        return listingDao.findAll();
    }

    @Override
    public void updateListing(Long id, Listing listing) {
        listing.setId(id);
        listingDao.save(listing);
    }

    @Override
    public void deleteListing(Long id) {
        listingDao.deleteById(id);
    }
}