import React, { useEffect } from "react";
import { useState } from "react";
import { listemployees } from "../services/EmployeeService";
import { useNavigate } from "react-router-dom";
import { deleteemployee } from "../services/EmployeeService";
const Listemployee = () => {
  const [employees, setEmployees] = useState([]);
  useEffect(() => {
    getallemployees();
  }, []);

  function getallemployees() {
    listemployees()
      .then((response) => {
        setEmployees(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  const navigate = useNavigate();
  function addnewemployee() {
    navigate("/add-employee");
  }

  function updateemployee(id) {
    navigate(`/edit-employee/${id}`);
  }

  function deleteem(id) {
    deleteemployee(id)
      .then((response) => {
        getallemployees();
      })
      .catch((error) => {
        console.error(error);
      });
  }

  return (
    <div className="container">
      <h2 position-absolute="true" top-0="true" end-0="true">
        List of employees
      </h2>
      <button className="btn btn-primary mb-2" onClick={addnewemployee}>
        Add employee
      </button>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Employee first name</th>
            <th>employee last name</th>
            <th>employee id</th>
            <th>Actions</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((e) => (
            <tr key={e.id}>
              <td>{e.firstname}</td>
              <td>{e.lastname}</td>
              <td>{e.email}</td>
              <td>
                <button
                  className="btn btn-info"
                  onClick={() => updateemployee(e.id)}
                >
                  Update
                </button>
              </td>
              <td>
                <button className="btn btn-info" onClick={() => deleteem(e.id)}>
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Listemployee;
