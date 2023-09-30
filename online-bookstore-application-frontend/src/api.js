// api.js
import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:3306/bookstore', // Replace with your backend API URL
});

export const fetchBooks = () => instance.get('/books');
export const addToCart = (bookId) => instance.post('/cart', { bookId });
export const checkout = (orderData) => instance.post('/checkout', orderData);
