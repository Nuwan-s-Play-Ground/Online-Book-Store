import React, { useState, useEffect } from 'react';
import axios from 'axios';

function ShoppingCart() {
  const [cartItems, setCartItems] = useState([]);

  useEffect(() => {
    // Fetch the user's shopping cart items from the backend
    axios.get('/api/cart')
      .then((response) => {
        setCartItems(response.data);
      })
      .catch((error) => {
        console.error('Error fetching shopping cart items: ', error);
      });
  }, []);

  const calculateTotalCost = () => {
    // Calculate the total cost based on the items in the cart
    return cartItems.reduce((total, item) => total + item.quantity * item.price, 0);
  };

  return (
    <div>
      <h1>Shopping Cart</h1>
      {cartItems.length === 0 ? (
        <p>Your shopping cart is empty.</p>
      ) : (
        <div>
          <table>
            <thead>
              <tr>
                <th>Title</th>
                <th>Quantity</th>
                <th>Price per Item</th>
                <th>Category</th>
                <th>Subcategory</th>
                <th>Total Price</th>
              </tr>
            </thead>
            <tbody>
              {cartItems.map((item) => (
                <tr key={item.id}>
                  <td>{item.title}</td>
                  <td>{item.quantity}</td>
                  <td>${item.price}</td>
                  <td>{item.category}</td>
                  <td>{item.subcategory}</td>
                  <td>${item.quantity * item.price}</td>
                </tr>
              ))}
            </tbody>
          </table>
          <p>Total Cost: ${calculateTotalCost()}</p>
        </div>
      )}
    </div>
  );
}

export default ShoppingCart;
