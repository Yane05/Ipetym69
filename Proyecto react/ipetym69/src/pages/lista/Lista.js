import './lista.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { MDBDataTable } from 'mdbreact';
import { useState } from 'react';


function Lista() {

    const [docentes, setDocentes] = useState([]);

    const buscarDocentes = async () => {

    let respuesta = await fetch ("http://localhost:8080/Ipetym69/docenteServlet", {
        "method": 'GET',
        "headers": {
            "Accept": 'application/json',
            "Content-Type": 'application/json'
        }})
    let json = respuesta.json();
    setDocentes(json);
    }

    const datos =
    {
        columns: [
            {
                label: 'Docente',
                field: 'docente',
                sort: 'asc'
            },
            {
                label: 'Materia',
                field: 'materia',
                sort: 'asc'
            },
            {
                label: 'Curso',
                field: 'curso',
                sort: 'asc'
            },
            {
                label: 'División',
                field: 'division',
                sort: 'asc'
            },
            {
                label: 'Día',
                field: 'dia',
                sort: 'asc'
            },
            {
                label: 'Horario',
                field: 'horario',
                sort: 'asc'
            },
            {
                label: 'Turno',
                field: 'turno',
                sort: 'asc'
            }
        ],
        rows: docentes
    }

    return (
        <div className="lista">
            <h1 className='titulo'>Escuela IPETYM N°69</h1>
            
                <button className="button"><a className='link' href="">Nuevo Docente</a></button>
                <button className="button"><a className='link' href="">Nueva Materia</a></button>
                <br /><br />

                <MDBDataTable
                    striped
                    bordered
                    data={datos}
                />
       
        </div>
    );
}

export default Lista;