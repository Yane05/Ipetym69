import './login.css';
import { useState } from 'react';
import axios from 'axios';

function Login() {
    const [datos, setDatos] = useState({
        nombreUsuario: '',
        contraseniaUsuario: ''
    })

    const handleInputChange = (event) => {
        console.log(event.target.name)
        console.log(event.target.value)
        setDatos({
            ...datos,
            [event.target.name]: event.target.value
        })
    }

    const datosForm = { nombreUsuario: datos.nombreUsuario, contraseniaUsuario: datos.contraseniaUsuario };
    let axiosConfig = {
        'Content-Type': 'application/json;charset=UTF-8',
        /*'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Headers': '*',
        'Access-Control-Allow-Methods': '*'*/

    };
    const url = 'http://localhost:8080/Ipetym69/loginServlet';

    const enviarDatos = (event) => {
        event.preventDefault()
        axios.post(url, datosForm, { "headers": axiosConfig })
            /* { headers: {
                 //'Accept': 'application/json',
                 'Content-Type': 'application/x-www-form-urlencoded',
               "Access-Control-Allow-Origin": "*",
               "Access-Control-Allow-Headers": "*",
               "Access-Control-Allow-Methods": "*"
         }})*/
            .then(response => {
                if (response.status === 200) {
                    window.location = "/docentes"
                } else {
                    window.location = "/"
                }
            })
            .catch(error => {
                alert(error);
            })
    }

    return (
        <div className="container">
            <section id="content">
                <form onSubmit={enviarDatos}>
                    <h1>IPETYM N°69</h1>
                    <h1>Iniciar sesión</h1>
                    <div>
                        <input type="text" placeholder="Usuario" name="nombreUsuario" onChange={handleInputChange} />
                    </div>
                    <div>
                        <input type="password" placeholder="Contraseña" name="contraseniaUsuario" onChange={handleInputChange} />
                    </div>
                    <div>
                        <input type="submit" value="Ingresar" />
                        <a href="">Registrarse</a>
                    </div>
                </form>
            </section>
        </div>
    );
}

export default Login;