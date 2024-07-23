import axios, { AxiosRequestConfig } from "axios";

const config = (defaultConfig : any, customConfig : any) => {
    return Object.assign({}, {
        ...defaultConfig, ...customConfig, headers: {...defaultConfig.headers, ...customConfig.headers}
    });
}

export class HttpService {
    defaultConfig = {
        headers: {
            'Content-Type': 'application/json'
        },
        timeout: 20000
    };
    serverDomain = 'http://localhost:8080';

    async post<T>(url: string, body?: unknown, axiosConfig?: AxiosRequestConfig): Promise<T> {
        return await axios.post(`${this.serverDomain}${url}`, JSON.stringify(body), config(this.defaultConfig, axiosConfig)) 
        .then((response) => {
            return response.data as T;
        })
    }

    async delete<T>(url: string, axiosConfig?: AxiosRequestConfig): Promise<T> {
        return await axios.delete(`${this.serverDomain}${url}`, config(this.defaultConfig, axiosConfig)) 
        .then((response) => {
            return response.data as T;
        })
    }

    async get<T>(url: string, axiosConfig?: AxiosRequestConfig): Promise<T> {
        return await axios.get(`${this.serverDomain}${url}`, config(this.defaultConfig, axiosConfig)) 
        .then((response) => {
            return response.data as T;
        })
    }

    async put<T>(url: string, body?: unknown,  axiosConfig?: AxiosRequestConfig): Promise<T> {
        return await axios.put(`${this.serverDomain}${url}`, JSON.stringify(body), config(this.defaultConfig, axiosConfig)) 
        .then((response) => {
            return response.data as T;
        })
    }
}

