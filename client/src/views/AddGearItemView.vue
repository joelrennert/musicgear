<script setup>
import HelloWorld from '../components/HelloWorld.vue'
// import SearchBox from '../components/SearchBox.vue'
import NavItems from '../components/NavItems.vue'
import MusicGearService from '../services/MusicGearService'
import AddItemCard from '../components/AddItemCard.vue'

</script>

<template>
  <main >
    <header>
      <div class="wrapper">
        <HelloWorld msg="music gear" />
        <div class="search">
          <NavItems />
          <div class="h4title">
            <h4>MUSIC GEAR INFORMATION CENTER</h4>
          </div>
          <div class="blank"></div>
          <!-- <div class="sortContainer">
            <label for="sort"></label>
            <select v-model="sortKey" id="sort">
              <option value="gearId">ID</option>
              <option value="name">Name</option>
              <option value="type">Type</option>
              <option value="vintage">Vintage</option>
            </select>
          </div>
          <SearchBox @search="filterGearItems" /> -->
        </div>
      </div>
    </header>

    <div class="container fade-in">
      <AddItemCard />
    </div>
  </main>
</template>

<script>


export default {
  components: {
    HelloWorld,
    // SearchBox,
    AddItemCard
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
    handleGearItemAdded(newGearItem) {
      // Handle the newly added gear item, e.g., add it to a list of gear items
      console.log('New gear item added:', newGearItem)
    },
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
            item.type.toLowerCase().includes(this.filter) ||
            item.description.toLowerCase().includes(this.filter)
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
@keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

.fade-in {
  animation: fadeIn .2s ease-in-out;
}

.blank {
  display: flex;
  width: 30%;
}
.h4title {
  display: flex;
  font-family: 'Jura';
  font-size: 1.4rem;
  color: rgba(0, 0, 0, 0.638);
  padding: 3px;
  width: 100%;
  flex-grow: 4;
  align-items: center;
  justify-content: space-around;
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
    width: 10%;
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
    width: 50px;
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
