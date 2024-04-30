import { useEffect, useState } from "react"
import gestionService from "../services/gestion.service.js";
import { Link } from "react-router-dom";

export default function HistorialList() {
  const [historial, setHistorial] = useState([]);

  async function fetchHistorial() {
    try{      
      const response = await gestionService.getHistoriales();  
      setHistorial(response.data);
    }catch(error) {
      alert("Error al obtener los historiales.");
    }
  }
  
  useEffect(() => {
    fetchHistorial();
  }, [])

  return (
    <div className="container">
      <h1>Lista Historiales</h1>
  
      <table className="table">
        <thead>
          <tr>
            <th scope="col">Id Historial</th>
            <th scope="col">Patente</th>
            <th scope="col">Rut</th>
            <th scope="col">Numero de Reparaciones</th>
            <th scope="col">Monto Total</th>
          </tr>
        </thead>
        <tbody>        
          {                                 
            historial.map((historial, index) => (
              <tr key={index}>
                <td>{historial.idHistorial}</td>
                <td>{historial.patente}</td>
                <td>{historial.rut}</td>
                <td>{historial.numeroReparaciones}</td>
                <td>{historial.montoTotalFinal}</td>
              </tr>
            ))
          }
        </tbody>
      </table>
    </div>   
  )
}