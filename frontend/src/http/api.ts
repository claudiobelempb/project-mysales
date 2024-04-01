import Axios, { AxiosInstance } from 'axios';

export const api: AxiosInstance = Axios.create({
  baseURL: 'http://localhost:8080/api'
});
