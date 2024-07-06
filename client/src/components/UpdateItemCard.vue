<template>
  <div class="itemCard">
    <h1 class="name">UPDATE GEAR ITEM</h1>
    <div class="aboutcontent">
      <h3>Update Gear Item</h3>

      <form @submit.prevent="updateGearItem" :key="localItem.id" class="addContainer">
        <div>
  <label for="nameField">Name:</label>
  <input type="text" v-model="localItem.name" id="nameField" name="nameField" required />
</div>
<div>
  <label for="typeField">Type:</label>
  <input type="text" v-model="localItem.type" id="typeField" name="typeField" required />
</div>
<div>
  <label for="descriptionField">Description:</label>
  <textarea v-model="localItem.description" id="descriptionField" name="descriptionField" required></textarea>
</div>
<div>
  <label for="vintageField">Vintage:</label>
  <input type="checkbox" v-model="localItem.vintage" id="vintageField" name="vintageField" />
</div>
<button type="submit">Update</button>
      </form>
    </div>
  </div>
</template>
<script>

export default {
  props: {
    item: {
      type: Object,
      required: true,
      default: () => ({}) // Provide a default value
    }
  },
  data() {
    return {
      localItem: { ...this.item } // Create a local copy of the item prop
    }
  },
  methods: {
    updateGearItem() {
  console.log('Emitting update event with item:', this.localItem);
  this.$emit('update-gear-item', this.localItem);
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
