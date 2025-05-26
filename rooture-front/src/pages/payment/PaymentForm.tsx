import { useState } from 'react';
import { processPayment } from '../../api/paymentApi';

export const PaymentForm = () => {
  const [amount, setAmount] = useState('');
  const [method, setMethod] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = async () => {
    const response = await processPayment({ amount: parseFloat(amount), method });
    setMessage(response.data);
  };

  return (
    <div>
      <h2>Process Payment</h2>
      <input type="number" placeholder="Amount" onChange={(e) => setAmount(e.target.value)} />
      <input type="text" placeholder="Method" onChange={(e) => setMethod(e.target.value)} />
      <button onClick={handleSubmit}>Submit</button>
      <p>{message}</p>
    </div>
  );
};