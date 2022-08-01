import './login.css';
import { useEffect, useState } from 'react';

function Login() {
    const [datos, setDatos] = useState({
        nombreUsuario: '',
        contraseniaUsuario: ''
    })

    const handleInputChange = (event) => {
        // console.log(event.target.name)
        // console.log(event.target.value)
        setDatos({
            ...datos,
            [event.target.name] : event.target.value
        })
    }

    const enviarDatos = (event) => {
        event.preventDefault()
        console.log('enviando datos...' + datos.nombreUsuario + ' ' + datos.contraseniaUsuario)
    }

    return (
        <div className="container">
            <section id="content">
                <form onSubmit={enviarDatos}>
                    <h1>IPETYM N°69</h1>
                    <h1>Iniciar sesión</h1>
                    <div>
                        <input type="text" placeholder="Usuario" name="nombreUsuario" onChange={handleInputChange}/>
                    </div>
                    <div>
                        <input type="password" placeholder="Contraseña" name="contraseniaUsuario" onChange={handleInputChange}/>
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