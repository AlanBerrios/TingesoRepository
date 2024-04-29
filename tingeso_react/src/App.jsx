import React, { useState, useEffect } from 'react';
import './App.css';
import Header from './components/Header';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import AutosList from './components/AutosList';
import Button from './components/Button';
import Contador from './components/Contador';
import Example from './components/Example';


function App() {
  return (
    <BrowserRouter>
      <Header/>

      <Routes>
        <Route path="/auto" element={<AutosList/>}/>
      </Routes>

    </BrowserRouter>
  );
}

export default App;
