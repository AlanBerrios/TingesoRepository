import { useEffect, useState } from "react";
import gestionService from "../services/gestion.service.js";
import FormReparacion from "./FormReparacion";

export default function CreateHistorial() {
  const [patente, setPatente] = useState("");
  const [rut, setRut] = useState("");
  const [numeroReparaciones, setNumeroReparaciones] = useState(1); // Valor inicial del select
  const [reparaciones, setReparaciones] = useState([]);
  const [historialList, setHistorialList] = useState([]);

  async function handleCrearHistorial(e) {
    e.preventDefault();
    try {
      const historialResponse = await gestionService.crearHistorial({
        // SETEAR ID HISTORIAL = NEXIDHISTORIAL ACA
        patente,
        rut,
        numeroReparaciones: numeroReparaciones // Guardar el número de reparaciones en el historial
      });

      const historialId = historialResponse.data.id; // Obtener el ID del historial creado

      // Guardar cada reparación y establecer la relación con el historial
      for (const reparacionData of reparaciones) {
        const reparacionResponse = await gestionService.crearReparacion({
          ...reparacionData,
          idHistorial: historialId,
        });
        console.log("Reparación creada:", reparacionResponse.data);
      }

      // Limpiar el formulario después de crear el historial
      setPatente("");
      setRut("");
      setNumeroReparaciones(1); // Restaurar el valor inicial del select
      setReparaciones([]);

      // Actualizar la lista de historiales después de crear uno nuevo
      fetchHistorial();

      alert("Historial creado con éxito");
    } catch (error) {
      console.log(error);
      alert("Error al crear el Historial.");
    }
  }

  const handleCrearReparacion = (reparacionData) => {
    setReparaciones([...reparaciones, reparacionData]);
  };

  useEffect(() => {
    fetchHistorial();
  }, []);

  async function fetchHistorial() {
    try {
      const response = await gestionService.getHistoriales();
      setHistorialList(response.data);
    } catch (error) {
      alert("Error al obtener los historiales.");
    }
  }

  const nextHistorialId = historialList.length + 1;

  return (
    <div className="container">
      <h1 className="mb-4">Crear Historial de reparaciones. ID: {nextHistorialId} </h1>
      <form className="border row g-3 px-4">
        <div className="col-12">
          <label htmlFor="patente" className="form-label">
            Patente
          </label>
          <input
            id="patente"
            type="text"
            className="form-control"
            value={patente}
            onChange={(e) => setPatente(e.target.value)}
          />
        </div>

        <div className="col-12">
          <label htmlFor="rut" className="form-label">
            Rut
          </label>
          <input
            id="rut"
            type="text"
            className="form-control"
            value={rut}
            onChange={(e) => setRut(e.target.value)}
          />
        </div>

        <div className="col-12 mt-4">
          <label htmlFor="numeroReparaciones" className="form-label">
            Número de Reparaciones
          </label>
          <select
            id="numeroReparaciones"
            className="form-select"
            value={numeroReparaciones}
            onChange={(e) => setNumeroReparaciones(parseInt(e.target.value))}
          >
            {[...Array(11)].map((_, index) => (
              <option key={index + 1} value={index + 1}>{index + 1}</option>
            ))}
          </select>
        </div>

        <div className="col-12 mt-4">
          {[...Array(numeroReparaciones)].map((_, index) => (
            <FormReparacion
              key={index}
              index={index}
              handleCrearReparacion={handleCrearReparacion}
            />
          ))}
        </div>

        <div className="col-12 mt-4 mb-4">
          <button
            type="submit"
            className="btn btn-primary"
            onClick={handleCrearHistorial}
          >
            Guardar Historial ID: {nextHistorialId}
          </button>
        </div>
      </form>
    </div>
  );
}
