import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function BookDetails({ match }) {
  const [book, setBook] = useState(null);
  const [isAddedToCart, setIsAddedToCart] = useState(false); // Track if the book is added to the cart

  useEffect(() => {
    // Fetch the book details by book ID from the backend
    axios.get(`/api/books/${match.params.bookId}`)
      .then((response) => {
        setBook(response.data);
      })
      .catch((error) => {
        console.error('Error fetching book details: ', error);
      });
  }, [match.params.bookId]);

  const handleAddToCart = () => {
    // Implement the logic to add the selected book to the shopping cart
    // Here, we'll set the isAddedToCart state to true as an example
    setIsAddedToCart(true);
  };

  if (!book) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <h1>{book.title}</h1>
      <h2>Author: {book.author}</h2>
      <img src={book.coverImage} alt={`${book.title} cover`} />
      <p>Price: ${book.price}</p>
      <p>Description: {book.description}</p>
      <p>Category: {book.category}</p>
      <p>Subcategory: {book.subcategory}</p>

      {isAddedToCart ? (
        <p>Added to Cart</p>
      ) : (
        <button onClick={handleAddToCart}>Add to Cart</button>
      )}

      {/* Provide a link to view the book details */}
      <Link to={`/book/${book.id}`}>View Details</Link>
    </div>
  );
}

export default BookDetails;
