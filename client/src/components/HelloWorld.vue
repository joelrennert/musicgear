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
      <img src="/src/assets/piano-svgrepo-com.svg" width="100" />
      <h1 class="green">{{ msg }}</h1>
      <img src="/src/assets/piano-svgrepo-com.svg" width="100" />
    </div>
    <h4>PERSONAL MUSIC GEAR INFORMATION CENTER</h4>

    <!-- <div class="search">
      <form id="form">
        <input type="search" id="query" class="searchbox" name="q" placeholder="Search..." />
        <button class="searchbutton">Search</button>
      </form>
    </div> -->
  </div>
</template>

<style scoped>
h1 {
  font-family: 'Jura';
  font-weight: 800;
  font-size: 4rem;
}

h4 {
  font-family: 'Jura';
  font-weight: 700;
  font-size: 1.2rem;
  padding-bottom: 15px;
}

img {
  padding: 10px;
}

.titleimage {
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  flex-grow: 1;
  width: 100%;
}

.search {
  margin-top: 5px;
  display: flex;
  width: 30%;
  justify-content: center;
}
.searchbox {
  border-radius: 6px;
  border-width: 0;
  padding: 5px;
}
.searchbutton {
  border-width: 0;
  border-radius: 6px;
  padding: 6px;
  margin-left: 5px;
}

.greetings {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.greetings h1,
.greetings h3 {
  /* padding: 5px; */
  text-align: center;
  color: rgb(0, 0, 0);
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
