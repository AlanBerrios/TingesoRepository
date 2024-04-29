import axios from "axios";

const CLIENTES_API_URL = "http://localhost:8090/api/clientes";
const AUTO_API_URL = "http://localhost:8090/api/auto";
const REPARACIONES_API_URL = "http://localhost:8090/api/reparaciones";
const BONO_API_URL = "http://localhost:8090/api/bono";
const HISTORIAL_API_URL = "http://localhost:8090/api/historial";
const RELACIONREPARACIONHISTORIAL_API_URL = "http://localhost:8090/api/relacionreparacionhistorial";

function crearCliente(cliente) {
  return axios.post(CLIENTES_API_URL, cliente);  
}

function getClientes() {
    return axios.get(CLIENTES_API_URL)
}

function getCliente(rutCliente) {  
    return axios.get(`${CLIENTES_API_URL}/${rutCliente}`)
}

function crearAuto(auto) {
    return axios.post(AUTO_API_URL, auto);  
}

function getAutos() {
    return axios.get(AUTO_API_URL)
}

function getAuto(patente) {
    return axios.get(`${AUTO_API_URL}/${patente}`)
}

function crearReparacion(reparacion) {
    return axios.post(REPARACIONES_API_URL, reparacion);
}

function getReparaciones() {
    return axios.get(REPARACIONES_API_URL)
}

function getReparacion(idReparacion) {
    return axios.get(`${REPARACIONES_API_URL}/${idReparacion}`)
}

function crearBono(bono) {
    return axios.post(BONO_API_URL, bono);
}

function getBonos() {
    return axios.get(BONO_API_URL)
}

function getBono(idBono) {
    return axios.get(`${BONO_API_URL}/${idBono}`)
}

function crearHistorial(historial) {
    return axios.post(HISTORIAL_API_URL, historial);
}

function getHistoriales() {
    return axios.get(HISTORIAL_API_URL)
}

function getHistorial(idHistorial) {
    return axios.get(`${HISTORIAL_API_URL}/${idHistorial}`)
}

function crearRelacionReparacionHistorial(relacionReparacionHistorial) {
    return axios.post(RELACIONREPARACIONHISTORIAL_API_URL, relacionReparacionHistorial);
}

function getRelacionReparacionHistorial() {
    return axios.get(RELACIONREPARACIONHISTORIAL_API_URL)
}

function getRelacionesReparacionHistorial(idRelacionReparacionHistorial) {
    return axios.get(`${RELACIONREPARACIONHISTORIAL_API_URL}/${idRelacionReparacionHistorial}`)
}





export default {crearCliente, getCliente, getClientes, crearAuto, getAuto, getAutos, crearReparacion, getReparacion, 
    getReparaciones, crearBono, getBono, getBonos, crearHistorial, getHistorial, getHistoriales, crearRelacionReparacionHistorial, getRelacionesReparacionHistorial, getRelacionReparacionHistorial
}

