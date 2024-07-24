import axios from "axios"

export const configureAxios = () => {
    axios.interceptors.request.use((config) => {
        if(config?.headers) {
            config.headers['Authorization'] = 'Bearer ' + JSON.parse(localStorage.getItem('jwt') as string).token() ?? '';
        }
        return config;
    });
}

export { axios };