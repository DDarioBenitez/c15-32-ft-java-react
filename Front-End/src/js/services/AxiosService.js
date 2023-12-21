import axios from "axios";

axios.defaults.baseURL = "http://opal.sa-east-1.elasticbeanstalk.com/api";
axios.defaults.headers.post["Content-Type"] = "application/json";


export const request = (method, url, data = {}) => {
    return axios({method: method, url: url, data: data});
}
