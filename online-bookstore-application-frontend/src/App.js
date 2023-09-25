import React from 'react';
import './App.css';
import Homepage from './Homepage';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import BookDetails from './BookDetails';

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          {/* Other routes */}
          <Route path="/book/:bookId" component={BookDetails} />
        </Switch>
      </Router>
      <Homepage />
    </div>
  );
}

export default App;
