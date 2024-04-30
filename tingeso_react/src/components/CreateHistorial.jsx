import { useEffect, useState } from "react"
import gestionService from "../services/gestion.service.js";

export default function CreateHistorial() {
  const [idHistorial, setIdHistorial] = useState("");
  const [patente, setPatente] = useState("");
  const [rut, setRut] = useState("");


  async function handleCrearHistorial(e) {
    e.preventDefault();
    try{
      const response = await gestionService.crearHistorial({
        idHistorial,
        patente,
        rut
      })

        setIdHistorial("");
        setPatente("");
        setRut("");

      alert("Historial creado con exito");
    }catch(error) {
      console.log(error);
      alert("Error al crear el Historial.");
    }

  }

  function handleIdChange(event) {
    setIdHistorial(event.target.value);
  }

  return (
        <div className="container">
        <h1 className="mb-4">Crear Historial</h1>
        <form className="border row g-3 px-4">

        <div className="col-md-6 mr-md-3">
          <label htmlFor="idHistorial" className="form-label">Id Historial</label>
            <input id="idHistorial" type="text" className="form-control" value={idHistorial} onChange={handleIdChange} />
        </div>

        <div className="col-12">
            <label htmlFor="patente" className="form-label">Patente</label>
            <input id="patente" type="text" className="form-control" value={patente} onChange={e => setPatente(e.target.value)} />
        </div>

        <div className="col-12">
            <label htmlFor="rut" className="form-label">Rut</label>
            <input id="rut" type="text" className="form-control" value={rut} onChange={e => setRut(e.target.value)} />
        </div>
        

        <div className="col-12 mt-4 mb-4" >
          <button type="submit" className="btn btn-primary" onClick={handleCrearEstudiante}>
            Crear Historial
          </button>
        </div>
      </form>
    </div>
  )
}