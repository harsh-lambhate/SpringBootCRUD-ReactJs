import axios from 'axios';

const CODER_BASE_REST_API_URL = 'http://localhost:8080/api/v1/coder';

class CoderService {
    getAllCoders(page, size) {
        return axios.get(`${CODER_BASE_REST_API_URL}?page=${page}&size=${size}&sort=id,asc`);
    }

    createCoder(coder) {
        return axios.post(CODER_BASE_REST_API_URL, coder);
    }

    getCoderById(coderId) {
        return axios.get(`${CODER_BASE_REST_API_URL}/${coderId}`);
    }

    updateCoder(coderId, coder) {
        return axios.put(`${CODER_BASE_REST_API_URL}/${coderId}`, coder);
    }

    deleteCoder(coderId) {
        return axios.delete(`${CODER_BASE_REST_API_URL}/${coderId}`);
    }
}

const coderService = new CoderService();
export default coderService;
