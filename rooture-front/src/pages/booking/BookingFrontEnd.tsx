import React, { useState, useEffect } from 'react';
import axios from 'axios';

export const BookingPage = () => {
  const [booking, setBooking] = useState({
    listingId: '',
    userId: '',
    startDate: '',
    endDate: ''
  });
  const [bookingDetails, setBookingDetails] = useState<any>(null);
  const [status, setStatus] = useState('');
  const [bookingId, setBookingId] = useState('');

  const handleInput = (e: React.ChangeEvent<HTMLInputElement>) => {
    setBooking({ ...booking, [e.target.name]: e.target.value });
  };

  const createBooking = async () => {
    const res = await axios.post('/api/bookings/create', booking);
    setBookingDetails(res.data);
  };

  const fetchBooking = async () => {
    const res = await axios.get(`/api/bookings/${bookingId}`);
    setBookingDetails(res.data);
  };

  const cancelBooking = async () => {
    const res = await axios.delete(`/api/bookings/cancel/${bookingId}`);
    alert(res.data);
  };

  const updateBookingStatus = async () => {
    const res = await axios.put(`/api/bookings/status/${bookingId}?status=${status}`);
    setBookingDetails(res.data);
  };

  return (
    <div>
      <h2>Create Booking</h2>
      <input name="listingId" placeholder="Listing ID" onChange={handleInput} />
      <input name="userId" placeholder="User ID" onChange={handleInput} />
      <input name="startDate" type="date" onChange={handleInput} />
      <input name="endDate" type="date" onChange={handleInput} />
      <button onClick={createBooking}>Book</button>

      <h2>Get Booking</h2>
      <input placeholder="Booking ID" value={bookingId} onChange={e => setBookingId(e.target.value)} />
      <button onClick={fetchBooking}>Fetch</button>

      <h2>Cancel Booking</h2>
      <button onClick={cancelBooking}>Cancel</button>

      <h2>Update Status (Admin)</h2>
      <input placeholder="New Status" value={status} onChange={e => setStatus(e.target.value)} />
      <button onClick={updateBookingStatus}>Update</button>

      {bookingDetails && (
        <div>
          <h3>Booking Info</h3>
          <pre>{JSON.stringify(bookingDetails, null, 2)}</pre>
        </div>
      )}
    </div>
  );
};
