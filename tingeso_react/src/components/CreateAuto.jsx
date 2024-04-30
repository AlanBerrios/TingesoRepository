import { useEffect, useState } from "react"
import gestionService from "../services/gestion.service.js";

export default function CreateAuto() {
    const [patente, setPatente] = useState("");
    const [marca, setMarca] = useState("");
    const [modelo, setModelo] = useState("");
    const [tipo, setTipo] = useState("");
    const [anio, setAnio] = useState("");
    const [tipoMotor, setTipoMotor] = useState("");
    const [kilometraje, setKilometraje] = useState("");
    const [numeroAsientos, setNumeroAsientos] = useState("");

    async function handleCrearAuto(a) {
        a.preventDefault();
        try {
            if (!Number.isInteger(parseInt(anio))){
                alert("Año debe ser numeros enteros.");
                return;
            }
            if (!Number.isInteger(parseInt(kilometraje))) {
                alert("Kilometraje debe ser numeros enteros.");
                return;
            }
            if (!Number.isInteger(parseInt(numeroAsientos))) {
                alert("Número de Asientos debe ser numeros enteros.");
                return;
            }

            const response = await gestionService.crearAuto({
                patente,
                marca,
                modelo,
                tipo,
                anio,
                tipoMotor,
                kilometraje,
                numeroAsientos
            })

            setPatente("");
            setMarca("");
            setModelo("");
            setTipo("");
            setAnio("");
            setTipoMotor("");
            setKilometraje("");
            setNumeroAsientos("");

            alert("Auto creado con éxito");
        } catch (error) {
            console.log(error);
            alert("Error al crear Auto.");
        }
    }

    function handlePatenteChange(event) {
        setPatente(event.target.value);
    }

    return (
        <div className="container">
        <h1 className="mb-4">Crear auto</h1>
        <form className="border row g-3 px-4">

            <div className="col-md-6 mr-md-3">
            <label htmlFor="patente" className="form-label">Patente</label>
            <input id="patente" type="text"  className="form-control" value={patente}  onChange={handlePatenteChange} />          
            </div>

            <div className="col-md-6 mr-md-3">
            <label htmlFor="nombre" className="form-label">Marca</label>
            <input id="marca" type="text" className="form-control" value={marca} onChange={a => setMarca(a.target.value)} />
            </div>
        
            <div className="col-md-6">
            <label htmlFor="modelo" className="form-label">Modelo</label>
            <input id="modelo" type="text" className="form-control" value={modelo} onChange={a => setModelo(a.target.value)} />
            </div>
            
            <div className="col-md-6">
            <label htmlFor="tipo" className="form-label">Tipo</label>
            <select id="tipo" className="form-control" value={tipo} onChange={a => setTipo(a.target.value)}>
                <option value="">Selecciona un tipo de Vehiculo</option>
                <option value="Sedan">Sedan</option>
                <option value="Hatchback">Hatchback</option>
                <option value="SUV">SUV</option>
                <option value="Pickup">Pickup</option>
                <option value="Furgoneta">Furgoneta</option>
            </select>
            </div>

            <div className="col-md-6">
            <label htmlFor="anio" className="form-label">Año</label>
            <input id="anio" type="text" className="form-control" value={anio} onChange={a => setAnio(a.target.value)} />
            </div>

            <div className="col-md-6">
            <label htmlFor="tipoMotor" className="form-label">Tipo Motor</label>
            <select id="tipoMotor" className="form-control" value={tipoMotor} onChange={a => setTipoMotor(a.target.value)}>
                <option value="">Selecciona un tipo de Motor</option>
                <option value="Gasolina">Gasolina</option>
                <option value="Diesel">Diesel</option>
                <option value="Hibrido">Hibrido</option>
                <option value="Electrico">Electrico</option>
            </select>
            </div>

            <div className="col-md-6">
            <label htmlFor="kilometraje" className="form-label">Kilometraje</label>
            <input id="kilometraje" type="text" className="form-control" value={kilometraje} onChange={a => setKilometraje(a.target.value)} />
            </div>

            <div className="col-md-6">
            <label htmlFor="numeroAsientos" className="form-label">Numero Asientos</label>
            <input id="numeroAsientos" type="text" className="form-control" value={numeroAsientos} onChange={a => setNumeroAsientos(a.target.value)} />
            </div>

            <div className="col-12 mt-4 mb-4" >
            <button type="submit" className="btn btn-primary" onClick={handleCrearAuto}>
                Crear Auto
            </button>
            </div>
        </form>
        </div>
    )
}