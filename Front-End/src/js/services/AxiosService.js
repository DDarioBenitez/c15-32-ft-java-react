import axios from "axios";

axios.defaults.baseURL = "https://c15-32-ft-java-react-production.up.railway.app/api";
axios.defaults.headers.post["Content-Type"] = "application/json";


export const request = (method, url, data = {}) => {
    return axios({ method: method, url: url, data: data });
}
