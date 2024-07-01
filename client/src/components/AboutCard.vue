<template>
  <div class="itemCard">
    <h1 class="name">MUSIC GEAR</h1>
    <div class="aboutcontent">
      <!-- <img src="/src/assets/piano-svgrepo-com.svg" width="200" /> -->
      <p class="subtitle">BASIC PERSONAL MUSIC GEAR INFORMATION CENTER</p>
      <img src="/src/assets/equaliser-svgrepo-com.svg" width="200px" />

      <div class="text">
        <p>This program is my attempt to demonstrate CRUD functionality in a full stack web app</p>
        <div class="postman">
          <img src="/src/assets/postman.png" class="postmanimg" height="270" />
          <div class="features">
            <p>Written by Joel Rennert</p>
            <p>-------------------</p>
            <p>Tools used:</p>
            <p>Java, Postgres, Vue.js</p>
            <p>-------------------</p>
            <p>Thanks for looking!</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {}
</script>
<style scoped>
.subtitle {
  font-style: italic;
}
.postmanimg {
  border-radius: 16px;
}

.postman {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px;
}

.features {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: left;
  padding: 20px;
  flex-grow: 1;
  height: 100%;
}

.text {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  /* padding: 20px; */
  line-height: 2;
}
.aboutcontent {
  display: flex;
  flex-direction: column;
  padding: 20px;
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
