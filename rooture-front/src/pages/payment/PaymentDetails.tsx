import { useState } from 'react';
import { getPaymentDetails } from '../../service/payment/api';

export const PaymentDetails = () => {
  const [bookingId, setBookingId] = useState('');
  const [details, setDetails] = useState<any>(null);

  const fetchDetails = async () => {
    const response = await getPaymentDetails(Number(bookingId));
    setDetails(response.data);
  };

  return (
    <div>
      <h2>Payment Details</h2>
      <input type="text" placeholder="Booking ID" onChange={(e) => setBookingId(e.target.value)} />
      <button onClick={fetchDetails}>Fetch</button>
      {details && (
        <div>
          <p>Amount: {details.amount}</p>
          <p>Date: {details.date}</p>
          <p>Method: {details.method}</p>
        </div>
      )}
    </div>
  );
};