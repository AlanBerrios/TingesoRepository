import React, { useState, useEffect } from 'react';
import './App.css';
import Header from './components/Header';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import AutosList from './components/AutosList';
import CreateAuto from './components/CreateAuto';
import CreateHistorial from './components/CreateHistorial';
import ReparacionList from './components/ReparacionList';
import HistorialList from './components/HistorialList';
import FormReparacion from './components/FormReparacion';
import R1 from './components/R1';
import R2 from './components/R2';
import R4 from './components/R4';
import Home from './components/Home';

function App() {
  return (
    <BrowserRouter>
      <Header/>

      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/auto" element={<AutosList/>}/>
        <Route path="/auto/crear" element={<CreateAuto/>}/>
        <Route path="/reparacion" element={<ReparacionList/>}/>
        <Route path="/historial" element={<HistorialList/>}/>
        <Route path="/historial/crear" element={<CreateHistorial/>}/> 
        <Route path="/r1" element={<R1/>}/>
        <Route path="/r2" element={<R2/>}/>
        <Route path="/r4" element={<R4/>}/>
        

      </Routes>

    </BrowserRouter>
  );
}

export default App;
