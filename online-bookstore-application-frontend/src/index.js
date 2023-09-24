import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import './index.css';
import { BrowserRouter as Router } from 'react-router-dom';
ReactDOM.render(
  <Router>
    <Switch>
      <App />
      <Router path="/cart" component={ShoppingCart} />
      <Router path="/checkout" component={Checkout} />
    </Switch>
  </Router>,
  document.getElementById('root')
);
