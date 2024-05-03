import { useEffect, useState } from "react"
import gestionService from "../services/gestion.service.js";
import { Link } from "react-router-dom";

export default function ReparacionList() {
  const [reparacion, setReparacion] = useState([]);

  async function fetchReparacion() {
    try{      
      const response = await gestionService.getReparaciones();  
      setReparacion(response.data);
    }catch(error) {
      alert("Error al obtener las Reparaciones.");
    }
  }
  
  useEffect(() => {
    fetchReparacion();
  }, [])

  return (
    <div className="container">
      <h1>Lista Reparaciones</h1>
  
      <table className="table">
        <thead>
          <tr>
            <th scope="col">Patente</th>
            <th scope="col">Tipo Reparacion</th>
            <th scope="col">Descripcion</th>
            <th scope="col">Fecha Ingreso</th>
            <th scope="col">Hora Ingreso</th>
            <th scope="col">Fecha Salida</th>
            <th scope="col">Hora Salida</th>
            <th scope="col">Fecha Retiro</th>
            <th scope="col">Hora Retiro</th>
          </tr>
        </thead>
        <tbody>        
          {                                 
            reparacion.map((reparacion, index) => (
              <tr key={index}>
                <td>{reparacion.patente}</td>
                <td>{reparacion.tipoReparacion}</td>
                <td>{reparacion.descripcion}</td>
                <td>{reparacion.fechaIngreso}</td>
                <td>{reparacion.horaIngreso}</td>
                <td>{reparacion.fechaSalida}</td>
                <td>{reparacion.horaSalida}</td>
                <td>{reparacion.fechaRetiro}</td>
                <td>{reparacion.horaRetiro}</td>
              </tr>
            ))
          }
        </tbody>
      </table>
    </div>   
  )
}