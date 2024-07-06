import axios from 'axios';

// Create an axios instance with a base URL
const http = axios.create({
  baseURL: 'http://localhost:9000',
  headers: {
    'Content-Type': 'application/json'
  }
});

export default {
  list() {
    return http.get('/musicgear');
  },

  getGearItemById(id) {
    return http.get(`/musicgear/${id}`);
  },

  getGearItemByType(type) {
    return http.get('/musicgear', { params: { type } });
  },

  getGearItemByName(name) {
    return http.get('/musicgear', { params: { name } });
  },

  addNewGearItem(gearItem) {
    return http.post('/musicgear', gearItem);
  },

  updateGearItem(id, updatedItem) {
    return http.put(`/musicgear/${id}`, updatedItem);
  },

  updateGearItemTypeById(id, type) {
    return http.put(`/musicgear/${id}`, { type });
  },

  updateGearItemDescriptionById(id, description) {
    return http.put(`/musicgear/${id}`, { description });
  },

  deleteGearItemById(id) {
    return http.delete(`/musicgear/${id}`);
  },

  searchGearItems(filter) {
    return http.get('/musicgear', { params: { name: filter } });
  }
};