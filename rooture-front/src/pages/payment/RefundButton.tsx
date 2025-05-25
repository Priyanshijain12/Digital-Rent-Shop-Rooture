import { useState } from 'react';
import { processRefund } from '../../service/payment/api';

export const RefundButton = () => {
  const [bookingId, setBookingId] = useState('');
  const [message, setMessage] = useState('');

  const handleRefund = async () => {
    const response = await processRefund(Number(bookingId));
    setMessage(response.data);
  };

  return (
    <div>
      <h2>Refund</h2>
      <input type="text" placeholder="Booking ID" onChange={(e) => setBookingId(e.target.value)} />
      <button onClick={handleRefund}>Refund</button>
      <p>{message}</p>
    </div>
  );
};
