import { Link } from "react-router-dom";

export default function Header() {
  return (
    <nav className="navbar navbar-expand-lg bg-body-tertiary mb-3" style={{ position: 'fixed', top: 0, left: 0, width: '120%', zIndex: 1000}}>
      <div className="container-fluid">
        <a className="navbar-brand" href="/">Autofix</a>
        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" 
          aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
          <ul className="navbar-nav">
            <li className="nav-item">
                <Link className="nav-link" to="/auto/crear">Crear auto</Link>
            </li>
            <li className="nav-item">
                <Link className="nav-link" to="/auto">Lista Autos</Link>
            </li>
            <li className="nav-item">
                <Link className="nav-link" to="/historial/crear">Crear Reparaciones</Link>
            </li>
            <li className="nav-item">
                <Link className="nav-link" to="/historial">Lista Historiales</Link>
            </li>
            <li className="nav-item">
                <Link className="nav-link" to="/reparacion">Lista Reparaciones</Link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}
