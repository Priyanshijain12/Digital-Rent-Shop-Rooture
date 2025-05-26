import axios from 'axios';
const API_URL = '/api/payments';

export const processPayment = (data: any) => axios.post(`${API_URL}/process`, data);
export const getPaymentDetails = (bookingId: number) => axios.get(`${API_URL}/details/${bookingId}`);
export const processRefund = (bookingId: number) => axios.post(`${API_URL}/refund/${bookingId}`);
