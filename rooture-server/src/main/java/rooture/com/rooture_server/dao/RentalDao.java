package com.rooture.repository;

import com.rooture.model.RentalListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentalDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertRental(RentalListing rental) {
        String sql = "INSERT INTO rental_listing (title, location, price, type) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, rental.getTitle(), rental.getLocation(), rental.getPrice(), rental.getType());
    }

    public void updateRental(RentalListing rental) {
        String sql = "UPDATE rental_listing SET title = ?, location = ?, price = ?, type = ? WHERE id = ?";
        jdbcTemplate.update(sql, rental.getTitle(), rental.getLocation(), rental.getPrice(), rental.getType(), rental.getId());
    }

    public List<RentalListing> findRentalsByLocation(String location) {
        String sql = "SELECT * FROM rental_listing WHERE location = ?";
        return jdbcTemplate.query(sql, new Object[]{location}, new BeanPropertyRowMapper<>(RentalListing.class));
    }

    public void bookRental(int listingId, int tenantId) {
        String sql = "INSERT INTO bookings (listing_id, tenant_id, booking_date) VALUES (?, ?, CURRENT_DATE)";
        jdbcTemplate.update(sql, listingId, tenantId);
    }

    public void createAgreement(int listingId, int tenantId) {
        String sql = "INSERT INTO agreements (listing_id, tenant_id, agreement_text) VALUES (?, ?, 'Standard agreement')";
        jdbcTemplate.update(sql, listingId, tenantId);
    }

    public String generateReport() {
        String sql = "SELECT COUNT(*) FROM rental_listing";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return "Total listings: " + count;
    }
}
