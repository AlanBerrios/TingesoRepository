import { useEffect, useState } from "react";
import gestionService from "../services/gestion.service.js";

export default function ReparacionList() {
  const [reparaciones, setReparaciones] = useState([]);

  useEffect(() => {
    const fetchReparaciones = async () => {
      try {
        const response = await gestionService.getReparaciones();
        const reparacionesData = response.data;

        const reparacionesArray = await calcularCantidadPorTipo(reparacionesData);

        // Ordenar el array de reparaciones por monto total de mayor a menor
        reparacionesArray.sort((a, b) => b.montoTotal - a.montoTotal);

        setReparaciones(reparacionesArray);
      } catch(error) {
        alert("Error al obtener las Reparaciones.");
      }
    };

    fetchReparaciones();
  }, []);

  // Función para calcular la cantidad de tipos de vehículo por cada tipo de reparación
  const calcularCantidadPorTipo = async (reparacionesData) => {
    const reparacionesInfo = {};

    for (const reparacion of reparacionesData) {
      const { tipoReparacion, patente } = reparacion;

      // Obtener el tipo de vehículo a partir de la patente
      const autoResponse = await gestionService.getAuto(patente);
      const tipoVehiculo = autoResponse.data.tipo;

      // Obtener el monto total de la reparación
      const montoTotalResponse = await gestionService.getMontoTotal(patente);
      const montoTotal = montoTotalResponse.data;

      // Actualizar el objeto de información de reparaciones
      if (!reparacionesInfo[tipoReparacion]) {
        reparacionesInfo[tipoReparacion] = {
          Sedan: tipoVehiculo === 'Sedan' ? 1 : 0,
          Hatchback: tipoVehiculo === 'Hatchback' ? 1 : 0,
          SUV: tipoVehiculo === 'SUV' ? 1 : 0,
          Pickup: tipoVehiculo === 'Pickup' ? 1 : 0,
          Furgoneta: tipoVehiculo === 'Furgoneta' ? 1 : 0,
          montoTotal
        };
      } else {
        reparacionesInfo[tipoReparacion][tipoVehiculo]++;
        reparacionesInfo[tipoReparacion].montoTotal += montoTotal;
      }
    }

    // Convertir el objeto de información de reparaciones en un array
    const reparacionesArray = Object.entries(reparacionesInfo).map(([tipoReparacion, info]) => ({
      tipoReparacion,
      Sedan: info.Sedan,
      Hatchback: info.Hatchback,
      SUV: info.SUV,
      Pickup: info.Pickup,
      Furgoneta: info.Furgoneta,
      montoTotal: info.montoTotal
    }));

    return reparacionesArray;
  };

  return (
    <div className="container">
      <h1>Lista Reparaciones</h1>

      <table className="table">
        <thead>
          <tr>
            <th scope="col">Tipo Reparación</th>
            <th scope="col">Sedan</th>
            <th scope="col">Hatchback</th>
            <th scope="col">SUV</th>
            <th scope="col">Pickup</th>
            <th scope="col">Furgoneta</th>
            <th scope="col">Monto Total</th>
          </tr>
        </thead>
        <tbody>        
          {reparaciones.map((reparacion, index) => (
            <tr key={index}>
              <td>{reparacion.tipoReparacion}</td>
              <td>{reparacion.Sedan}</td>
              <td>{reparacion.Hatchback}</td>
              <td>{reparacion.SUV}</td>
              <td>{reparacion.Pickup}</td>
              <td>{reparacion.Furgoneta}</td>
              <td>{reparacion.montoTotal}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>   
  );
}
