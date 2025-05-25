package com.rooture.rentals.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rooture.rentals.model.Listing;

public interface ListingDao extends JpaRepository<Listing, Long> {
}