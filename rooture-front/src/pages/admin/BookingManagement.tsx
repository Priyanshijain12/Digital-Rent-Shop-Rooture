import React, { useEffect, useState } from 'react';

interface Booking {
  id: number;
  listingId: number;
  bookedBy?: string;
  status?: string;
}

const BookingManagement = () => {
  const [bookings, setBookings] = useState<Booking[]>([]);

  useEffect(() => {
    fetch('/api/admin/bookings')
      .then(res => res.json())
      .then(setBookings);
  }, []);

  return (
    <div>
      <h2>Booking Management</h2>
      <ul>
        {bookings.map(booking => (
          <li key={booking.id}>
            Booking #{booking.id} - Status: {booking.status}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BookingManagement;
