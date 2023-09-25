import React, { useEffect, useState } from 'react';
import axios from 'axios'; // Import axios to make API requests
import Navigation from './Navigation'; // Import your Navigation component
import BookList from './BookList';

export function Homepage() {
  const [featuredBooks, setFeaturedBooks] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState('');

  const handleCategorySelect = (category) => {
    // Update the selected category state
    setSelectedCategory(category);
  };

  // Fetch featured books from the backend API
  useEffect(() => {
    // Make an API request to get featured books
    axios.get('/api/books/featured')
      .then((response) => {
        setFeaturedBooks(response.data);
      })
      .catch((error) => {
        console.error('Error fetching featured books: ', error);
      });
  }, []); // Empty dependency array to run this effect only once on component mount

  // Fetch books by selected category when the category changes
  useEffect(() => {
    if (selectedCategory) {
      axios.get(`/api/books?category=${selectedCategory}`)
        .then((response) => {
          setFeaturedBooks(response.data);
        })
        .catch((error) => {
          console.error('Error fetching books by category: ', error);
        });
    }
  }, [selectedCategory]); // Run this effect whenever selectedCategory changes

  return (
    <div>
      <h1>Welcome to the Online Bookstore</h1>
      <Navigation onCategorySelect={handleCategorySelect} />
      <h2>Featured Books</h2>
      <BookList books={featuredBooks} />
    </div>
  );
}
