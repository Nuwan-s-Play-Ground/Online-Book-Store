# Online Bookstore Application - Frontend

This is the frontend part of the Online Bookstore Application, allowing users to browse, search, and purchase books online.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Homepage and Book Listing](#homepage-and-book-listing)
- [Book Categories](#book-categories)
- [Book Details](#book-details)
- [Shopping Cart](#shopping-cart)
- [Checkout](#checkout)
- [Responsive Design](#responsive-design)
- [License](#license)

## Features

### Homepage and Book Listing

1. **Homepage**:
   - Displays a welcoming homepage.
   - Lists featured books from various categories.
   - Fetches and displays a list of books from the backend API.
   
2. **Book Listing**:
   - Each book card shows its title, author, cover image, price, category, and subcategory.

### Book Categories

3. **Navigation Menu**:
   - Implements a navigation menu with book categories.
   - Allows users to filter books by category and subcategory.

### Book Details

4. **Book Details Page**:
   - Implements a page where users can view detailed information about a selected book.
   - Shows the book's title, author, cover image, price, description, category, and subcategory.
   - Includes an "Add to Cart" button to add the book to the cart.

### Shopping Cart

5. **Shopping Cart Page**:
   - Creates a shopping cart page where users can view the books they've added.
   - Displays book titles, quantities, total prices per item, categories, and subcategories.
   - Calculates and displays the total cost of items in the cart.

### Checkout

6. **Checkout Page**:
   - Implements a checkout page where users can review their order.
   - Includes a form for users to enter their shipping details.
   - Upon submitting the order, sends a request to the backend to process the purchase.

### Responsive Design

7. **Responsive Design**:
   - Ensures the application is responsive and works well on both desktop and mobile devices.

## Technologies Used

- React: Frontend framework for building user interfaces.
- React Router: For client-side routing within the application.
- Axios: For making HTTP requests to the backend API.
- HTML/CSS: For structuring and styling the web pages.
- Bootstrap (optional): For responsive design and UI components.

# Online Bookstore Application - Backend

This is the backend part of the Online Bookstore Application, responsible for managing user authentication, book management, categories, shopping cart, orders, database operations, error handling, and more.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Authentication](#authentication)
- [Book Management](#book-management)
- [Book Categories and Subcategories](#book-categories-and-subcategories)
- [Shopping Cart and Orders](#shopping-cart-and-orders)
- [Order Processing](#order-processing)
- [Database](#database)
- [Error Handling](#error-handling)
- [License](#license)

## Features

### Authentication

1. **User Registration and Login**:
   - Implements user registration and login functionality using JWT tokens.
   - Secures the API endpoints so that only authenticated users can access them.

### Book Management

2. **API Endpoints for CRUD Operations**:
   - Creates API endpoints for CRUD operations on books.
   - Each book has attributes such as title, author, price, description, category, and subcategory.
   - Includes validation for incoming book data.

### Book Categories and Subcategories

3. **API Endpoints for Categories and Subcategories**:
   - Implements API endpoints to manage book categories and subcategories.
   - Each category and subcategory has a name and an optional description.

### Shopping Cart and Orders

4. **Shopping Cart Management**:
   - Implements APIs to manage the user's shopping cart, including category and subcategory details.
   - Users can add books to the cart, view the cart, and place orders.

5. **Order Processing**:
   - Creates an API endpoint to process orders.
   - Upon receiving an order, calculates the total price and updates book quantities.

### Database

6. **Relational Database**:
   - Utilizes a relational database (e.g., MySQL, PostgreSQL) to store book, user, category, and subcategory data.
   - Establishes relationships between books and categories/subcategories.

### Error Handling

7. **Error Handling**:
   - Implements error handling and returns appropriate HTTP status codes for different scenarios.

## Technologies Used

- Spring Boot: Spring Boot is a Java-based framework that simplifies the development of web   applications, including RESTful APIs. It provides built-in features for handling web requests, managing security, and connecting to databases.
- JSON Web Tokens (JWT): For user authentication and authorization.
- Relational Database (e.g., MySQL): For data storage.
- Sequelize (optional): ORM for interacting with the database.
- Express Validator (optional): For request data validation.

## License

This backend project is licensed under [License Name] - see the [LICENSE](License.txt) file for details.

