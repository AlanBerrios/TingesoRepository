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


function App() {
  return (
    <BrowserRouter>
      <Header/>

      <Routes>
        <Route path="/auto" element={<AutosList/>}/>
        {/* <Route path="/auto/:patente" element={<AutoView/>}/> */}
        <Route path="/auto/crear" element={<CreateAuto/>}/>

        
        <Route path="/reparacion" element={<ReparacionList/>}/>
        {/* <Route path="/reparacion/:id" element={<ReparacionView/>}/> */}
        
        <Route path="/historial" element={<HistorialList/>}/>

        <Route path="/historial/crear" element={<CreateHistorial/>}/> 

        {/*
        Aqui se vera el historial especificamente, mostrando todos las reparaciones vinculadas al idHistorial
        <Route path="/historial/:id" element={<HistorialView/>}/>*/}
        

      </Routes>

    </BrowserRouter>
  );
}

export default App;
