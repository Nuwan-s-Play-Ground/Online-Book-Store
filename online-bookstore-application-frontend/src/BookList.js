import React, { useEffect, useState } from 'react';
import { fetchBooks, addToCart } from './api'; 

function BookList() {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    // Fetch books from the backend when the component mounts
    fetchBooks()
      .then((response) => {
        setBooks(response.data);
      })
      .catch((error) => {
        console.error('Error fetching books: ', error);
      });
  }, []);

  const handleAddToCart = (bookId) => {
    // Add a book to the cart when a button is clicked
    addToCart(bookId)
      .then(() => {
        // Handle success (e.g., show a notification)
        console.log('Book added to cart.');
      })
      .catch((error) => {
        console.error('Error adding to cart: ', error);
      });
  };

  return (
    <div>
      <h1>Book List</h1>
      <ul>
        {books.map((book) => (
          <li key={book.id}>
            {book.title}
            <button onClick={() => handleAddToCart(book.id)}>Add to Cart</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BookList;
