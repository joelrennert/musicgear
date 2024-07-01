<template>
  <div class="itemCard">
    <h1 class="name">ADD GEAR ITEM</h1>
    <div class="aboutcontent">
      <h3>Add A New Gear Item</h3>

      <form @submit.prevent="submitForm" class="addContainer">
        <div>
          <label for="name">Name:</label>
          <input type="text" v-model="gearItem.name" id="name" required />
        </div>
        <div>
          <label for="type">Type:</label>
          <input type="text" v-model="gearItem.type" id="type" required />
        </div>
        <div>
          <label for="description">Description:</label>
          <textarea v-model="gearItem.description" id="description" required></textarea>
        </div>
        <div>
          <label for="isVintage">Is Vintage:</label>
          <input type="checkbox" v-model="gearItem.isVintage" id="isVintage" />
        </div>
        <button type="submit" class="submitButton">Add Gear Item</button>
      </form>
    </div>
  </div>
</template>
<script>
import MusicGearService from '@/services/MusicGearService'

export default {
  data() {
    return {
      gearItem: {
        name: '',
        type: '',
        description: '',
        isVintage: false
      },
      isLoading: false
    }
  },
  methods: {
    submitForm() {
      this.isLoading = true
      MusicGearService.addNewGearItem(this.gearItem)
        .then((response) => {
          if (response.status === 201) {
            console.log('Gear item added successfully')
            this.$emit('gear-item-added', response.data)
            this.resetForm()
          }
        })
        .catch((error) => {
          console.error('Error adding gear item:', error)
        })
        .finally(() => {
          this.isLoading = false
        })
    },
    resetForm() {
      this.gearItem = {
        name: '',
        type: '',
        description: '',
        isVintage: false
      }
    }
  }
}
</script>
<style scoped>
h3 {
  font-family: 'Jura';
}

label {
  font-family: 'Jura';
}

input,
textarea {
  font-family: 'Jura';
  font-size: 1rem;
  border-width: 1px;
  border-color: black;
  border-radius: 6px;
  border-width: 0px;
  padding: 6px;
}

.addContainer {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 10px;
  width: 50%;
}

.submitButton {
  font-family: 'Jura';
  font-size: 1rem;
  font-weight: 600;
  background-color: rgb(46, 45, 45);
  color: white;
  border-width: 0;
  border-radius: 6px;
  padding: 4px;
}

.aboutcontent {
  display: flex;
  flex-direction: column;
  padding: 40px;
  gap: 20px;
  justify-content: flex-start;
  align-items: center;
  height: 77vh;
}

.itemCard {
  display: flex;
  /* flex-direction: column; */
  justify-content: space-evenly;
  align-items: center;
  /* flex-grow: 1; */

  border-radius: 6px;
  padding: 5px;
  margin: 10px;
  width: 100%;

  color: rgb(0, 0, 0);

  background: rgba(255, 255, 255, 0.116);
  border-radius: 20px;
  backdrop-filter: blur(5px);
  -webkit-backdrop-filter: blur(5px);
  border: 1px solid rgb(255, 255, 255);
  box-shadow: 5px 5px 6px 2px rgba(0, 0, 0, 0.2);
  background: rgb(206, 245, 243);
  background: linear-gradient(
    90deg,
    rgba(206, 245, 243, 0.249) 0%,
    rgba(241, 251, 229, 0.253) 53%,
    rgba(206, 245, 243, 0.259) 100%
  );
}

.name {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-grow: 1;
  font-size: 1.4rem;
  color: rgba(0, 0, 0, 0.667);
  font-family: 'Jura';
  background-color: rgba(255, 255, 255, 0.23);
  padding: 6px;
  border-radius: 10px;
  width: 100%;
}
</style>
