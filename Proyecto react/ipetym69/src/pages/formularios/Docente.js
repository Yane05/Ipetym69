import './formularios.css';
import { useState } from 'react';
import axios from 'axios';

function Docente() {
    const [docente, setDocente] = useState({
        nombre: '',
        apellido: '',
        dni: '',
        telefono: '',
        email: '',
        legajo: ''
    })

    const handleInputChange = (event) => {
        console.log(event.target.name)
        console.log(event.target.value)
        setDocente({
            ...docente,
            [event.target.name]: event.target.value
        })
    }

    const datosForm = { 
        nombre: docente.nombre, 
        apellido: docente.apellido,
        dni: docente.dni,
        telefono: docente.telefono,
        email: docente.email,
        legajo: docente.legajo
    };
    
    let axiosConfig = {
        'Content-Type': 'application/json;charset=UTF-8'
    };
    const url = 'http://localhost:8080/Ipetym69/docenteServlet';

    const enviarDatos = (event) => {
        event.preventDefault()
        axios.post(url, datosForm, { "headers": axiosConfig })
            .then(() => {
                window.location = "/docentes"
            })
            .catch(error => {
                alert(error);
            })
    }

    return (
        <div>
            <a href="lista.html" style={{ float: 'left' }}>Volver</a>
            <form onSubmit={enviarDatos}>
                <div className="center">
                    <table>
                        <tbody>
                            <tr>
                                <td className='titulo' style={{ paddingLeft: "20px"}}>
                                    <div className="dash"></div>
                                </td>
                                <td className='titulo'>
                                    <h1>Docente</h1>
                                </td>
                                <td className='titulo' style={{ paddingRight: "20px"}}>
                                    <div className="dash"></div>
                                </td>
                            </tr>
                            <tr>
                                <td colSpan={3}>
                                    <div>
                                        <input type="text" placeholder="Nombre" name="nombre" onChange={handleInputChange}/>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colSpan={3}>
                                    <div>
                                        <input type="text" placeholder="Apellido" name="apellido" onChange={handleInputChange}/>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colSpan={3}>
                                    <div>
                                        <input type="text" placeholder="DNI" name="dni" onChange={handleInputChange} style={{ float: "left", width: "42%" }} />
                                        <input type="text" placeholder="Teléfono" name="telefono" onChange={handleInputChange} style={{ float: "left", width: "42%" }} />
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colSpan={3}>
                                    <div>
                                        <input type="text" placeholder="Email" name="email" onChange={handleInputChange} style={{ float: "left", width: "56%" }} />
                                        <input type="text" placeholder="Legajo" name="legajo" onChange={handleInputChange} style={{ float: "left", width: "28%" }} />
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colSpan={3}>
                                    <div className="">
                                        <input type="submit" value="Registrar" />
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </form>
        </div>
    );
}

export default Docente;