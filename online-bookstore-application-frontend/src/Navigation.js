import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Navigation({ onCategorySelect }) {
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState('');

  useEffect(() => {
    // Fetch the list of categories from the backend
    axios.get('/api/categories')
      .then((response) => {
        setCategories(response.data);
      })
      .catch((error) => {
        console.error('Error fetching categories: ', error);
      });
  }, []);

  const handleCategoryChange = (event) => {
    const selectedCategory = event.target.value;
    setSelectedCategory(selectedCategory);
    onCategorySelect(selectedCategory);
  };

  return (
    <div>
      <label htmlFor="category">Select Category:</label>
      <select
        id="category"
        name="category"
        value={selectedCategory}
        onChange={handleCategoryChange}
      >
        <option value="">All Categories</option>
        {categories.map((category) => (
          <option key={category.id} value={category.name}>
            {category.name}
          </option>
        ))}
      </select>
    </div>
  );
}

export default Navigation;
