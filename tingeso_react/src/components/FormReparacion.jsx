import * as React from 'react';
import { useEffect, useState } from "react"
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import gestionService from "../services/gestion.service.js";
import { DemoContainer } from '@mui/x-date-pickers/internals/demo';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { TimePicker } from '@mui/x-date-pickers/TimePicker';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';

export default function FormReparacion() {
  const [open, setOpen] = useState(false);
  const [formData, setFormData] = useState({});
  const [idHistorial, setIdHistorial] = useState("");
  const [patente, setPatente] = useState("");
  const [tipoReparacion, setTipoReparacion] = useState("");
  const [fechaIngreso, setFechaIngreso] = useState(null);
  const [horaIngreso, setHoraIngreso] = useState(null);
  const [reparacionesList, setReparacionesList] = useState([]);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  async function handleCrearReparacion(e) {
    e.preventDefault();
    try {
      const reparacionData = {
        ...formData,
        patente,
        tipoReparacion,
        fechaIngreso: fechaIngreso ? fechaIngreso.format("YYYY-MM-DD") : null, // Formatear la fecha como LocalDate
        horaIngreso: horaIngreso ? horaIngreso.format("HH:mm:ss") : null, // Formatear la hora como LocalTime
      };

      const relacionReparacionHistorialdata = {
        idHistorial,
        idReparacion
      }

      await gestionService.crearRelacionReparacionHistorial(relacionReparacionHistorialdata);
  
      await gestionService.crearReparacion(reparacionData);
  
      setPatente("");
      setTipoReparacion("");
      setFechaIngreso(null);
      setHoraIngreso(null);
      setFormData({});
      setOpen(false);
  
      alert("Reparación creada con éxito");
    } catch (error) {
      console.log(error);
      alert("Error al crear la reparación.");
    }
  }

  useEffect(() => {
    fetchReparacion();
  }, []);

  async function fetchReparacion() {
    try {
      const response = await gestionService.getReparaciones();
      setReparacionesList(response.data);
    } catch (error) {
      alert("Error al obtener las reparaciones.");
    }
  }

  const idReparacion = reparacionesList.length + 1;
  
  const handleFormChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handlePatenteChange = (event) => {
    setPatente(event.target.value);
  };

  const handleIdHistorialChange = (event) => {
    setIdHistorial(event.target.value);
  };
  
  const handleDateChange = (date) => {
    setFechaIngreso(date);
  };

  const handleTimeChange = (time) => {
    setHoraIngreso(time);
  };

  return (
    <React.Fragment>
      <Button variant="outlined" onClick={handleClickOpen}>
        Abrir formulario de reparación
      </Button>
      <Dialog
        open={open}
        onClose={handleClose}
        PaperProps={{
          component: 'form',
          onSubmit: (event) => {
            event.preventDefault();
            handleClose();
          },
        }}
      >
        <DialogTitle>Crear Reparación</DialogTitle>
        <DialogContent>
          <DialogContentText>
            Por favor ingrese los datos de la reparación. Asegurese de que Patente e Id del Historial coincidan con lo esperado.
          </DialogContentText>
          <TextField
            required
            margin="dense"
            id="patente"
            name="patente"
            label="Patente"
            type="text"
            fullWidth
            variant="standard"
            onChange={handlePatenteChange}
          />
          <TextField
            required
            margin="dense"
            id="idHistorial"
            name="idHistorial"
            label="idHistorial"
            type="text"
            fullWidth
            variant="standard"
            onChange={handleIdHistorialChange}
          />
          <select
            autoFocus
            required
            id="tipoReparacion"
            name="tipoReparacion"
            className="form-select"
            value={tipoReparacion}
            onChange={(e) => setTipoReparacion(e.target.value)}
          >
            <option value="">Selecciona un tipo de reparación</option>
            <option value="1">Reparaciones del Sistema de Frenos</option>
            <option value="2">Servicio del Sistema de Refrigeración</option>
            <option value="3">Reparaciones del Motor</option>
            <option value="4">Reparaciones de la Transmision</option>
            <option value="5">Reparación del Sistema Eléctrico</option>
            <option value="6">Reparaciones del Sistema de Escape</option>
            <option value="7">Reparación de Neumáticos y Ruedas</option>
            <option value="8">Reparaciones de la Suspensión y la Dirección</option>
            <option value="9">Reparación del Sistema de Aire Acondicionado y Calefacción</option>
            <option value="10">Reparaciones del Sistema de Combustible</option>
            <option value="11">Reparación y Reemplazo del Parabrisas y Cristales</option>
          </select>

          <TextField
            required
            margin="dense"
            id="descripcion"
            name="descripcion"
            label="Descripción"
            type="text"
            fullWidth
            variant="standard"
            onChange={handleFormChange}
          />
          
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DemoContainer components={['DatePicker']}>
              <DatePicker
                label="Fecha de Ingreso"
                value={fechaIngreso}
                onChange={handleDateChange}
                renderInput={(props) => <TextField {...props} />}
              />
            </DemoContainer>
          </LocalizationProvider>
          
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DemoContainer components={['TimePicker']}>
              <TimePicker
                label="Hora de Ingreso"
                value={horaIngreso}
                onChange={handleTimeChange}
                renderInput={(props) => <TextField {...props} />}
              />
            </DemoContainer>
          </LocalizationProvider>

        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Cancelar</Button>
          <Button type="submit" onClick={handleCrearReparacion}>Guardar</Button>
        </DialogActions>
      </Dialog>
    </React.Fragment>
  );
}
