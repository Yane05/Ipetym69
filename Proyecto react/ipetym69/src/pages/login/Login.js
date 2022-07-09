import './login.css';

function Login() {
    
    return (
        <div className="container">
            <section id="content">
                <form action="/lista" method="">
                    <h1>IPETYM N°69</h1>
                    <h1>Iniciar sesión</h1>
                    <div>
                        <input type="text" placeholder="Usuario" name="usuario" />
                    </div>
                    <div>
                        <input type="password" placeholder="Contraseña" name="pass" />
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