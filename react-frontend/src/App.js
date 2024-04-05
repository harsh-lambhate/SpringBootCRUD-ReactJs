import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import './App.css';
import About from './components/About';
import AddCoderComponent from './components/AddCoderComponent';
import CodersListComponent from './components/CodersListComponent';
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import Timer from './components/Timer';


function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div >
        <Routes >
          <Route path="/" exact element={<About />} />
          <Route path="/about"  element={<About />} />
          <Route path="/coders" element={<CodersListComponent />} />
          <Route path="/add-coder" element={<AddCoderComponent />} />
          <Route path="/edit-coder/:id" element={<AddCoderComponent />} />
          <Route path="/timer" element={<Timer />} />
        </Routes>
        </div>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
