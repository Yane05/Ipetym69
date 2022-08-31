import './formularios.css';
//import { useState } from 'react';
//import axios from 'axios';

function Docente() {
    return (
        <div>
            <a href="lista.html" style={{ float: 'left' }}>Volver</a>
            <form action="guardar">
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
                                        <input type="text" placeholder="Nombre" name="nombreDocente" />
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colSpan={3}>
                                    <div>
                                        <input type="text" placeholder="Apellido" name="apellido" />
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colSpan={3}>
                                    <div>
                                        <input type="text" placeholder="DNI" name="dni" style={{ float: "left", width: "42%" }} />
                                        <input type="text" placeholder="Teléfono" name="telefono" style={{ float: "left", width: "42%" }} />
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colSpan={3}>
                                    <div>
                                        <input type="text" placeholder="Email" name="Email" style={{ float: "left", width: "56%" }} />
                                        <input type="text" placeholder="Legajo" name="legajo" style={{ float: "left", width: "28%" }} />
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