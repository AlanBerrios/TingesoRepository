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

  // Función para calcular la cantidad de tipos de motor por cada tipo de reparación
  const calcularCantidadPorTipo = async (reparacionesData) => {
    const reparacionesInfo = {};

    for (const reparacion of reparacionesData) {
      const { tipoReparacion, patente } = reparacion;

      // Obtener el tipo de motor a partir de la patente
      const autoResponse = await gestionService.getAuto(patente);
      const tipoMotor = autoResponse.data.tipoMotor;

      // Obtener el monto total de la reparación
      const montoTotalResponse = await gestionService.getMontoTotal(patente);
      const montoTotal = montoTotalResponse.data;

      // Actualizar el objeto de información de reparaciones
      if (!reparacionesInfo[tipoReparacion]) {
        reparacionesInfo[tipoReparacion] = {
          Gasolina: tipoMotor === 'Gasolina' ? 1 : 0,
          Diesel: tipoMotor === 'Diesel' ? 1 : 0,
          Hibrido: tipoMotor === 'Hibrido' ? 1 : 0,
          Electrico: tipoMotor === 'Electrico' ? 1 : 0,
          montoTotal
        };
      } else {
        reparacionesInfo[tipoReparacion][tipoMotor]++;
        reparacionesInfo[tipoReparacion].montoTotal += montoTotal;
      }
    }

    // Convertir el objeto de información de reparaciones en un array
    const reparacionesArray = Object.entries(reparacionesInfo).map(([tipoReparacion, info]) => ({
      tipoReparacion,
      Gasolina: info.Gasolina,
      Diesel: info.Diesel,
      Hibrido: info.Hibrido,
      Electrico: info.Electrico,
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
            <th scope="col">Gasolina</th>
            <th scope="col">Diesel</th>
            <th scope="col">Hibrido</th>
            <th scope="col">Electrico</th>
            <th scope="col">Monto Total</th>
          </tr>
        </thead>
        <tbody>        
          {reparaciones.map((reparacion, index) => (
            <tr key={index}>
              <td>{reparacion.tipoReparacion}</td>
              <td>{reparacion.Gasolina}</td>
              <td>{reparacion.Diesel}</td>
              <td>{reparacion.Hibrido}</td>
              <td>{reparacion.Electrico}</td>
              <td>{reparacion.montoTotal}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>   
  );
}
