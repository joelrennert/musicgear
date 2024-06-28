<template>
  <article v-for="item in gearArray" v-bind:key="item.gearId" class="itemCard">
    <ul>
      <div class="name">
        <h4>{{ item.name }}</h4>
      </div>
      <li class="image">
        <div class="image-container">
          <img src="/src/assets/equaliser-svgrepo-com.svg" width="150px" height="150px" />
        </div>
      </li>
      <li>
        <div class="type">{{ item.type }}</div>
      </li>
      <li>
        <div class="description">{{ item.description }}</div>
      </li>
      <li>
        <div class="isVintage">Vintage: {{ item.vintage ? 'Yes' : 'No' }}</div>
      </li>
    </ul>
  </article>
</template>

<script>
export default {
  data() {
    return {}
  },

  props: {
    gearArray: {
      type: Array,
      required: true
    }
  }
}
</script>
<style>
body {
  display: flex;
  overflow: auto;
}

ul {
  padding: 0px;
}

li {
  display: flex;
  flex-wrap: wrap;
  list-style: none;
  font-size: 1.1rem;
}

.itemCard {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  flex-grow: 1;

  border-radius: 6px;
  padding: 10px;
  margin: 15px;

  /* UNCOMMENT BELOW TO SQUARE UP LAYOUT :) */
  width: 30%;

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
  font-size: 1.6rem;
  color: black;
  font-family: 'Jura';
}

.name,
.image,
.type,
.description,
.isVintage {
  display: flex;
  flex-direction: column;
  align-items: left;
  justify-content: space-around;
  flex-wrap: wrap;
  padding: 10px;
  font-weight: 400;
}

.image {
  display: flex;
  justify-content: center;
  align-items: center;
  /* width: 100px;
  height: 100px; */
}

.image-container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 150px;
  height: 150px;
}
</style>
