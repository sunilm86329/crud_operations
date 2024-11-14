import React, { useEffect, useState } from "react";
import { createemployee, updatedemployee } from "../services/EmployeeService";
import { useNavigate, useParams } from "react-router-dom";
import { getdata } from "../services/EmployeeService";
export const EmployeeComponent = () => {
  const [firstname, setFirstname] = useState("");
  const [lastname, setLastName] = useState("");
  const [email, setEmail] = useState("");
  //const [id, setId] = useState();
  const { id } = useParams();

  const [errors, setErrors] = useState({
    firstname: "",
    lastname: "",
    email: "",
  });
  const navigator = useNavigate();

  useEffect(() => {
    if (id) {
      getdata(id)
        .then((response) => {
          setFirstname(response.data.firstname);
          setLastName(response.data.lastname);
          setEmail(response.data.email);
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }, [id]);

  function saveorupdateemployee(e) {
    e.preventDefault();

    if (validation()) {
      const employee = { firstname, lastname, email };
      console.log(employee);
      if (id) {
        updatedemployee(id, employee)
          .then((response) => {
            console.log(response.data);
            navigator("/");
          })
          .catch((error) => {
            console.error(error);
          });
      } else {
        createemployee(employee)
          .then((response) => {
            console.log(response.data);
            navigator("/");
          })
          .catch((error) => {
            console.error(error);
          });
      }
    }
  }

  function validation() {
    let valid = true;
    const errorCopy = { ...errors };
    if (firstname.trim()) {
      errorCopy.firstname = "";
    } else {
      errorCopy.firstname = "first name is required";
      valid = false;
    }
    if (lastname.trim()) {
      errorCopy.lastname = "";
    } else {
      errorCopy.lastname = "last name is required";
      valid = false;
    }
    if (email.trim()) {
      errorCopy.email = "";
    } else {
      errorCopy.email = "email is required";
      valid = false;
    }
    setErrors(errorCopy);
    return valid;
  }

  function pagetitle() {
    if (id) {
      return <h2 className="text-center">update employee</h2>;
    } else {
      return <h2 className="text-center">add employee</h2>;
    }
  }

  return (
    <div className="container">
      <br></br>
      <div className="row">
        <div className="card d-flex aligns-items-center justify-content-center card  w-75 position-absolute top-50 start-50 translate-middle">
          {pagetitle()}
          <div className="card-body">
            <form>
              <div className="form-group mb-2">
                <label className="form-label">first name</label>
                <input
                  type="text"
                  placeholder="Enter first name"
                  value={firstname}
                  className={`form-control ${
                    errors.firstname ? "is-invalid" : ""
                  }`}
                  onChange={(e) => setFirstname(e.target.value)}
                ></input>
                {errors.firstname && (
                  <div className="'invalid-feedback">{errors.firstname}</div>
                )}
              </div>
              <div className="form-group mb-2">
                <label className="form-label">last name</label>
                <input
                  type="text"
                  placeholder="Enter last name"
                  value={lastname}
                  className={`form-control ${
                    errors.lastname ? "is-invalid" : ""
                  }`}
                  onChange={(e) => setLastName(e.target.value)}
                ></input>
                {errors.lastname && (
                  <div className="'invalid-feedback">{errors.lastname}</div>
                )}
              </div>
              <div className="form-group mb-2">
                <label className="form-label">email</label>
                <input
                  type="text"
                  placeholder="Enter email"
                  value={email}
                  className={`form-control ${errors.email ? "is-invalid" : ""}`}
                  onChange={(e) => setEmail(e.target.value)}
                ></input>
                {errors.email && (
                  <div className="'invalid-feedback">{errors.email}</div>
                )}
              </div>
              <button
                className="btn btn-success"
                type="submit"
                onClick={saveorupdateemployee}
              >
                submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};
