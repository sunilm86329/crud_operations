import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080/api/employees/all";
const REST_API_post = "http://localhost:8080/api/employees";
const REST_API_PUT = "http://localhost:8080/api/employees";
const REST_get = "http://localhost:8080/api/employees";

export const listemployees = () => axios.get(REST_API_BASE_URL);
export const createemployee = (employee) => axios.post(REST_API_post, employee);
export const getdata = (employeeid) => axios.get(REST_get + "/" + employeeid);
export const updatedemployee = (id, employee) =>
  axios.put(REST_API_PUT + "/" + id, employee);
export const deleteemployee = (employeeid) => {
  return axios.delete(REST_API_PUT + "/" + employeeid);
};
