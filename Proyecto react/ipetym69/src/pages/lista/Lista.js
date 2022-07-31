import './lista.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { MDBDataTable } from 'mdbreact';
import { useEffect, useState } from 'react';
import axios from 'axios';


function Lista() {

    const [docentes, setDocentes] = useState([]);

    useEffect(() => {
        buscarDocentes();
    }, []);

    const buscarDocentes = () => {
        axios.get('http://localhost:8080/Ipetym69/docenteServlet')
            .then(response => {
                setDocentes(response.data);
            })
            .catch(e => {
                console.log(e);
            })
    }
    const datos =
    {
        columns: [
            {
                label: 'Nombre',
                field: 'nombre',
                sort: 'asc'
            },
            {
                label: 'Apellido',
                field: 'apellido',
                sort: 'asc'
            },
            {
                label: 'Dni',
                field: 'dni',
                sort: 'asc'
            },
            {
                label: 'Telefono',
                field: 'telefono',
                sort: 'asc'
            },
            {
                label: 'Email',
                field: 'email',
                sort: 'asc'
            },
            {
                label: 'Legajo',
                field: 'legajo',
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