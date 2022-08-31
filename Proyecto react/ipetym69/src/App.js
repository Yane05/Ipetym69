import Lista from "./pages/lista/Lista";
import Login from "./pages/login/Login";
import Materia from "./pages/formularios/Materia";
import Docente from "./pages/formularios/Docente";
import { BrowserRouter, Routes, Route } from 'react-router-dom';

//<Route index element={<Login />} />

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<Login />} />        
        <Route path="/docentes" element={<Lista />}></Route>
        <Route path="/nuevoDocente" element={<Docente />}></Route> 
        <Route path="/nuevaMateria" element={<Materia />}></Route>       
    </Routes>
    </BrowserRouter> 

  );
}

export default App;
