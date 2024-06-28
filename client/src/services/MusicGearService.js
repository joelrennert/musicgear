import axios from 'axios'

// eslint-disable-next-line no-unused-vars
const http = axios.create({
  baseURL: 'http://localhost:9000',
  headers: {
    'Content-Type': 'application/json'
}
})

export default {
  list() {
    return http.get('/musicgear');
  },

  getGearItemById(id) {
    return axios.get(`/musicgear/${id}`);
  },

  getGearItemByType(type) {
    return axios.get(`/musicgear?type=${type}`);
  },

  getGearItemByName(name) {
    return axios.get(`/musicgear?name=${name}`)
  },

  addNewGearItem(gearItem) {
    const addedGearItemDto = {
      gearId: gearItem.gearId,
      type: gearItem.type,
      name: gearItem.name,
      description: gearItem.description,
      isVintage: gearItem.isVintage
    }
    return axios.post('/musicgear', addedGearItemDto)
  },

  updateGearItemTypeById(id) {
    // hmm not sure what to put here
    return axios.put(`/musicgear/${id}`)
  },

  updateGearItemDescriptionById(id) {
    // hmm not sure what to put here
    return axios.put(`/musicgear/${id}`)
  },

  deleteGearItemById(id) {
    return axios.delete(`/musicgear/${id}`)
  },

  searchGearItems(filter) {
    return axios.get(`/musicgear?name=${filter}`)
  }
}
