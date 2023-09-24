import React, { useEffect, useState } from 'react';
import BookList from './BookList';

export function Homepage() {
    
    const [featuredBooks, setFeaturedBooks] = useState([]);
    const [selectedCategory, setSelectedCategory] = useState('');
  
    
  
    const handleCategorySelect = (category) => {
      // Update the selected category state
      setSelectedCategory(category);

    // Fetch featured books from the backend API
    useEffect(() => {
        // Make an API request to get featured books
        // Update the 'featuredBooks' state with the fetched data
        // Inside the useEffect block in Homepage.js
        axios.get('/api/books/featured')
            .then((response) => {
                setFeaturedBooks(response.data);
            })
            .catch((error) => {
                console.error('Error fetching featured books: ', error);
            });

        axios.get(`/api/books?category=${selectedCategory}`)
        .then((response) => {
        setFeaturedBooks(response.data);
        })
        .catch((error) => {
        console.error('Error fetching featured books: ', error);
        });


    }, []);

        return (
            <div>
                <h1>Welcome to the Online Bookstore</h1>
                <Navigation onCategorySelect={handleCategorySelect} />
                <h2>Featured Books</h2>
                <BookList books={featuredBooks} />
            </div>
        );
    }
}