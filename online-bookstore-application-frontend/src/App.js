import React from 'react';
import './App.css';
import Homepage from './Homepage';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import BookDetails from './BookDetails'; // Import your BookDetails component here

function App() {
  return (
    <><div className="App">
      <Homepage />
    </div><Router>
        <Switch>
          {/* Other routes */}
          <Route path="/book/:bookId" component={BookDetails} />
        </Switch>
      </Router></>
  );
}

export default App;
