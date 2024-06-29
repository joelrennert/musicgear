<script setup>
defineProps({
  msg: {
    type: String,
    required: true
  }
})
</script>

<script>
export default {
  created: function () {
    document.body.style.backgroundColor = '#637074'
  }
}
</script>

<template>
  <div class="greetings">
    <div class="titleimage">
      <img src="/src/assets/piano-svgrepo-com.svg" width="80" />
      <h1 class="green">{{ msg }}</h1>
      <img src="/src/assets/piano-svgrepo-com.svg" width="80" />
    </div>
    <h4>PERSONAL MUSIC GEAR INFORMATION CENTER</h4>
  </div>
</template>

<style scoped>
h1 {
  font-family: 'Gloria Hallelujah';
  /* font-family: 'Bungee Spice'; */
  /* font-family: 'Nabla'; */
  font-weight: 600;
  font-size: 3.7rem;
  padding-bottom: 10px;
  text-shadow: 4px 2px 2px rgba(0, 0, 0, 0.38);
  /* background-color: rgba(0, 0, 0, 0.32); */
  padding-left: 10px;
  padding-right: 10px;
  border-radius: 12px;
}

h4 {
  font-family: 'Jura';
  font-weight: 700;
  font-size: 1.2rem;
  /* padding-bottom: 15px; */
}

img {
  padding-top: 10px;
}

.titleimage {
  display: flex;
  justify-content: space-evenly;

  flex-grow: 1;
  width: 100%;
  padding: 5px;
}

.greetings {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.greetings h1,
.greetings h3 {
  text-align: center;
  color: rgb(96, 96, 96);
}
.greetings h4 {
  color: rgb(0, 0, 0);
}

@media (min-width: 1024px) {
  .greetings h1,
  .greetings h3 {

    text-align: center;
  }
}
</style>