<script setup>
import HelloWorld from '../components/HelloWorld.vue'
import SearchBox from '../components/SearchBox.vue'
import GearCards from '../components/GearCards.vue'
import NavItems from '../components/NavItems.vue'
import MusicGearService from '../services/MusicGearService'
</script>

<template>
  <main>
    <header>
      <div class="wrapper">
        <HelloWorld msg="music gear" />
        <div class="search">
          <NavItems />
          <SearchBox @search="filterGearItems" />
        </div>
      </div>
    </header>
    <div class="container">
      <GearCards :gearArray="filteredGearArray" />
    </div>
  </main>
</template>

<script>
export default {
  components: {
    HelloWorld,
    SearchBox,
    GearCards
  },
  data() {
    return {
      gearArray: [],
      filteredGearArray: [],
      filter: '',
      isLoading: true
    }
  },
  methods: {
    getGearItems() {
      this.isLoading = true
      MusicGearService.list()
        .then((response) => {
          this.gearArray = response.data
          this.filteredGearArray = response.data
          this.isLoading = false
          console.log(this.gearArray)
        })
        .catch((error) => {
          this.handleError(error)
        })
    },
    handleError(error) {
      this.isLoading = false
      console.log(error)
    },
    filterGearItems(query) {
      this.filter = query.toLowerCase()
      if (this.filter) {
        this.filteredGearArray = this.gearArray.filter(
          (item) =>
            item.name.toLowerCase().includes(this.filter) ||
            item.type.toLowerCase().includes(this.filter)
        )
      } else {
        this.filteredGearArray = this.gearArray
      }
    }
  },
  created() {
    this.getGearItems()
  }
}
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  flex-wrap: wrap;
  margin-top: 20px;
  margin-bottom: 50px;
  width: 80vw;
}
main {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.wrapper {
  display: flex;
  justify-content: center;
  line-height: 1.5;
  flex-grow: 1;
}
nav {
  display: flex;
  flex-grow: 1;
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
@media (min-width: 768px) {
  header {
    display: flex;
    justify-content: center;
    place-items: center;
    flex-grow: 1;
    position: sticky;
    top: 0;
    z-index: 1;
    width: 80vw;
    height: 10%;
    border-bottom-right-radius: 20px;
    border-bottom-left-radius: 20px;
    background: rgba(222, 222, 222, 0.366);
    box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
    backdrop-filter: blur(5px);
    -webkit-backdrop-filter: blur(5px);
    border: 1px solid rgb(255, 255, 255);
    border-top-width: 0;
    backdrop-filter: blur(5px);
    -webkit-backdrop-filter: blur(5px);
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
  .navsearchcontainer {
    display: flex;
    justify-content: space-between;
    width: 100%;
    flex-grow: 1;
    align-items: center;
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
    font-family: 'Jura';
    font-size: 1rem;
    padding: 10px;
  }
  .search {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding-right: 20px;
  }
  .searchbox {
    font-family: 'Jura';
    font-size: 0.8rem;
    border-radius: 6px;
    border-width: 0px;
    padding: 5px;
  }
  .searchbutton {
    font-family: 'Jura';
    font-size: 0.8rem;
    font-weight: 600;
    border-width: 0;
    border-radius: 6px;
    padding: 5px;
  }
}
</style>
