import { useEffect, useState } from "react";
import gestionService from "../services/gestion.service.js";
import { Link } from "react-router-dom";

export default function AutosList() {
  const [autos, setAutos] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await gestionService.getAutos();
        setAutos(response.data);
      } catch(error) {
        alert("Error al obtener los autos.");
      }
    };

    fetchData();
  }, []);

  useEffect(() => {
    const fetchAutoData = async (patente, index) => {
      try {
        // Verificar si los montos ya están presentes en el auto
        if (autos[index].sumaReparacionesNeto === undefined || autos[index].montoRecargo === undefined ||
            autos[index].montoDescuento === undefined || autos[index].montoTotal === undefined) {
          const sumaReparacionesResponse = await gestionService.getSumaReparacionesNeto(patente);
          const montoRecargoResponse = await gestionService.getMontoRecargo(patente);
          const montoDescuentoResponse = await gestionService.getMontoDescuento(patente);
          const montoTotalResponse = await gestionService.getMontoTotal(patente);

          const updatedAutos = [...autos];
          updatedAutos[index] = {
            ...updatedAutos[index],
            sumaReparacionesNeto: sumaReparacionesResponse.data,
            montoRecargo: montoRecargoResponse.data,
            montoDescuento: montoDescuentoResponse.data,
            montoTotal: montoTotalResponse.data
          };

          setAutos(updatedAutos);
        }
      } catch(error) {
        alert("Error al obtener los datos del auto.");
      }
    };

    autos.forEach((auto, index) => {
      fetchAutoData(auto.patente, index);
    });
  }, [autos]);

  return (
    <div className="container">
      <h1>Lista autos</h1>
  
      <table className="table">
        <thead>
          <tr>
            <th scope="col">Patente</th>
            <th scope="col">Marca</th>
            <th scope="col">Modelo</th>
            <th scope="col">Tipo Auto</th>
            <th scope="col">Suma Reparaciones</th>
            <th scope="col">Monto Recargo</th>
            <th scope="col">Monto Descuento</th>
            <th scope="col">IVA</th>
            <th scope="col">Monto Total</th>
          </tr>
        </thead>
        <tbody>        
          {                                 
            autos.map((auto, index) => (
              <tr key={index}>
                <td>{auto.patente}</td>
                <td>{auto.marca}</td>
                <td>{auto.modelo}</td>
                <td>{auto.tipo}</td>
                <td>{auto.sumaReparacionesNeto !== undefined ? auto.sumaReparacionesNeto : "N/A"}</td>
                <td>{auto.montoRecargo !== undefined ? auto.montoRecargo : "N/A"}</td>
                <td>{auto.montoDescuento !== undefined ? auto.montoDescuento : "N/A"}</td>
                <td>{auto.sumaReparacionesNeto !== undefined ? auto.sumaReparacionesNeto * 0.19 : "N/A"}</td>
                <td>{auto.montoTotal !== undefined ? auto.montoTotal : "N/A"}</td>
              </tr>
            ))
          }
        </tbody>
      </table>
    </div>   
  );
}
