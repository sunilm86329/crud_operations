import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import Listemployee from "./components/Listemployee";
import { HeaderComponent } from "./components/HeaderComponent";
import { FooterComponent } from "./components/FooterComponent";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { EmployeeComponent } from "./components/EmployeeComponent";

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      <HeaderComponent />
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Listemployee />}></Route>
          <Route path="/add-employee" element={<EmployeeComponent />}></Route>
          <Route
            path="/edit-employee/:id"
            element={<EmployeeComponent />}
          ></Route>
        </Routes>

        <FooterComponent />
      </BrowserRouter>
    </>
  );
}

export default App;
