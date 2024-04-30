import { useEffect, useState } from "react"
import gestionService from "../services/gestion.service.js";
import { Link } from "react-router-dom";

export default function AutosList() {
  const [auto, setAuto] = useState([]);

  async function fetchAutos() {
    try{      
      const response = await gestionService.getAutos();  
      setAuto(response.data);
    }catch(error) {
      alert("Error al obtener los autos.");
    }
  }
  
  useEffect(() => {
    fetchAutos();
  }, [])

  return (
    <div className="container">
      <h1>Lista autos</h1>
  
      <table className="table">
        <thead>
          <tr>
            <th scope="col">Patente</th>
            <th scope="col">Marca</th>
            <th scope="col">Modelo</th>
            <th scope="col">Año</th>
            <th scope="col">Tipo Auto</th>
            <th scope="col">Tipo Motor</th>
            <th scope="col">Kilometraje</th>
            <th scope="col">Numero Asientos</th>
          </tr>
        </thead>
        <tbody>        
          {                                 
            auto.map((auto, index) => (
              <tr key={index}>
                <td>{auto.patente}</td>
                <td>{auto.marca}</td>
                <td>{auto.modelo}</td>
                <td>{auto.anio}</td>
                <td>{auto.tipo}</td>
                <td>{auto.tipoMotor}</td>
                <td>{auto.kilometraje}</td>
                <td>{auto.numeroAsientos}</td>
              </tr>
            ))
          }
        </tbody>
      </table>
    </div>   
  )
}