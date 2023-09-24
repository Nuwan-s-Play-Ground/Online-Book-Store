import React, { useState } from 'react';
import axios from 'axios';

function Checkout() {
  const [shippingDetails, setShippingDetails] = useState({
    fullName: '',
    address: '',
    city: '',
    postalCode: '',
  });

  const handleSubmit = (e) => {
    e.preventDefault();

    // Create an order object with shipping details
    const order = {
      shippingDetails,
      // Add any other relevant order details here
    };

    // Send a request to the backend to process the purchase
    axios.post('/api/orders', order)
      .then((response) => {
        // Handle successful order submission (e.g., show a success message)
      })
      .catch((error) => {
        console.error('Error submitting the order: ', error);
        // Handle order submission error
      });
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setShippingDetails({
      ...shippingDetails,
      [name]: value,
    });
  };

  return (
    <div>
      <h1>Checkout</h1>
      <div>
        <h2>Order Summary</h2>
        {/* Display order summary details here */}
      </div>
      <div>
        <h2>Shipping Details</h2>
        <form onSubmit={handleSubmit}>
          <div>
            <label htmlFor="fullName">Full Name:</label>
            <input
              type="text"
              id="fullName"
              name="fullName"
              value={shippingDetails.fullName}
              onChange={handleInputChange}
              required
            />
          </div>
          <div>
            <label htmlFor="address">Address:</label>
            <input
              type="text"
              id="address"
              name="address"
              value={shippingDetails.address}
              onChange={handleInputChange}
              required
            />
          </div>
          <div>
            <label htmlFor="city">City:</label>
            <input
              type="text"
              id="city"
              name="city"
              value={shippingDetails.city}
              onChange={handleInputChange}
              required
            />
          </div>
          <div>
            <label htmlFor="postalCode">Postal Code:</label>
            <input
              type="text"
              id="postalCode"
              name="postalCode"
              value={shippingDetails.postalCode}
              onChange={handleInputChange}
              required
            />
          </div>
          <button type="submit">Place Order</button>
        </form>
      </div>
    </div>
  );
}

export default Checkout;
