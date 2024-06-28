<script setup>
// import { RouterLink } from 'vue-router'
import HelloWorld from './HelloWorld.vue'
</script>

<template>
  <header>
    <div class="wrapper">
      <HelloWorld msg="MUSIC GEAR" />
      <!-- <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/about">About</RouterLink>
      </nav> -->
    </div>
  </header>
</template>
<script>
// export default {}
</script>
<style>
wrapper {
  display: flex;
  justify-content: center;
  line-height: 1.5;
  flex-grow: 1;
}
nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
}

/* nav a.router-link-exact-active {
  color: black;
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
} */

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    justify-content: center;
    place-items: center;
    flex-grow: 1;
    position: sticky;
    top: 0;
    z-index: 1;

    border-bottom-right-radius: 20px;
    border-bottom-left-radius: 20px;
    /* padding: 10px; */
    padding-bottom: 15px;

    background: rgba(222, 222, 222, 0.366);

    box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
    backdrop-filter: blur(5px);
    -webkit-backdrop-filter: blur(5px);
    border: 1px solid rgb(255, 255, 255);
    border-top-width: 0;

    backdrop-filter: blur(5px);
    -webkit-backdrop-filter: blur(5px);
    /* border: 1px solid rgb(255, 255, 255); */
    box-shadow: 5px 5px 6px 2px rgba(0, 0, 0, 0.2);

    background: rgb(206, 245, 243);
    background: rgb(241, 251, 229);
    background: radial-gradient(
      circle,
      rgba(241, 251, 229, 1) 10%,
      rgba(241, 251, 229, 0.675) 50%,
      rgba(206, 245, 243, 0.669) 90%
    );
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    flex-grow: 2;
  }

  nav {
    font-size: 1rem;

    padding: 1rem 0;
    margin-top: 1rem;
  }
}
</style>
