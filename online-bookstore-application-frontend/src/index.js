import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import ShoppingCart from './ShoppingCart'; // Import your ShoppingCart component
import Checkout from './Checkout'; // Import your Checkout component
import './index.css';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'; // Import Switch and Route

ReactDOM.render(
  <Router>
    <Switch>
      <Route path="/cart" component={ShoppingCart} />
      <Route path="/checkout" component={Checkout} />
      <Route path="/" component={App} /> {/* Set a default route */}
    </Switch>
  </Router>,
  document.getElementById('root')
);
