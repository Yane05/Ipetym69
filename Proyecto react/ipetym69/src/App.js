import Lista from "./pages/lista/Lista";
import Login from "./pages/login/Login";
import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<Login />} />
        <Route path="/docentes" element={<Lista />}></Route>      
    </Routes>
    </BrowserRouter> 

  );
}

export default App;
