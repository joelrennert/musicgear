<script setup>
import { RouterLink } from 'vue-router'
</script>
<template>
  <nav>
    <RouterLink to="/">Home</RouterLink>
    <RouterLink to="/about">About</RouterLink>
    <RouterLink to="/about">Add Item</RouterLink>
  </nav>
</template>
<script>
export default {}
</script>
<style scoped>
nav {
  display: flex;
  flex-grow: 1;
  font-family: 'Jura';
  font-size: 1rem;
  padding: 10px;
  text-align: center;
}

nav a.router-link-exact-active {
  color: black;
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
}

nav a:first-of-type {
  border: 0;
}

</style>
