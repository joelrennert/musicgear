<script setup>
import HelloWorld from '../components/HelloWorld.vue'
import SearchBox from '../components/SearchBox.vue'
import NavItems from '../components/NavItems.vue'
import MusicGearService from '../services/MusicGearService'
import UpdateItemCard from '../components/UpdateItemCard.vue'

</script>

<template>
  <main>
    <header>
      <div class="wrapper">
        <HelloWorld msg="music gear" />
        <div class="search">
          <NavItems />
          <div class="h4title">
            <h4>MUSIC GEAR INFORMATION CENTER</h4>
          </div>
          <SearchBox @search="filterGearItems" />
        </div>
      </div>
    </header>

    <div class="container">
      <UpdateItemCard v-if="item"
      :item="item"
      @update-gear-item="updateGearItem" />
      <div v-else>Loading...</div> <!-- Show loading until item is fetched -->
    </div>
  </main>
</template>

<script>


export default {
  components: {
    HelloWorld,
    SearchBox,
    UpdateItemCard
  },
  props: ['gearId'],
  data() {
    return {
      item: null // Initialize item as null
    }
  },
  created() {
    console.log('Fetching gear item with ID:', this.gearId)
    MusicGearService.getGearItemById(this.gearId).then((response) => {
      console.log('Received item:', response.data)
      this.item = response.data
    }).catch(error => {
      console.error('Error fetching gear item:', error)
    })
  },
  methods: {
    updateGearItem(updatedItem) {
      console.log('Updating gear item with ID:', this.gearId)
      MusicGearService.updateGearItem(this.gearId, updatedItem)
        .then(() => {
          // Refresh the gear items on the main page
          this.$router.push({ name: 'home' })
        })
        .catch(error => {
          console.error('Error updating gear item:', error)
        })
    }
  }
}
</script>

<style scoped>
.h4title {
  display: flex;
  font-family: 'Jura';
  font-size: 1.4rem;
  color: rgba(0, 0, 0, 0.638);
  padding: 3px;
  width: 100%;
  flex-grow: 4;
  align-items: center;
  justify-content: space-evenly;
}
.titleimage {
  display: flex;
  justify-content: space-evenly;
  flex-grow: 1;
  width: 80%;
  /* padding: 5px; */
}
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

@media (min-width: 768px) {
  header {
    display: flex;
    justify-content: center;
    place-items: center;
    flex-grow: 1;
    position: sticky;
    top: 0;
    z-index: 1;
    width: 90vw;
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
      rgba(203, 223, 222, 0.669) 90%
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
