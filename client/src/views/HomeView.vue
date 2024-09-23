<script setup>
import { ref, computed, onMounted } from 'vue'
import HelloWorld from '../components/HelloWorld.vue'
import SearchBox from '../components/SearchBox.vue'
import GearCards from '../components/GearCards.vue'
import NavItems from '../components/NavItems.vue'
import MusicGearService from '../services/MusicGearService'

const gearArray = ref([])
const filteredGearArray = ref([])
const filter = ref('')
const sortKey = ref('gearId')
const isLoading = ref(true)

const getGearItems = async () => {
  isLoading.value = true
  try {
    const response = await MusicGearService.list()
    gearArray.value = response.data
    filteredGearArray.value = response.data
    isLoading.value = false
  } catch (error) {
    handleError(error)
  }
}

const handleError = (error) => {
  isLoading.value = false
  console.error(error)
}

const filterGearItems = (query) => {
  filter.value = query.toLowerCase()
  if (filter.value) {
    filteredGearArray.value = gearArray.value.filter(
      (item) =>
        item.name.toLowerCase().includes(filter.value) ||
        item.type.toLowerCase().includes(filter.value) ||
        item.description.toLowerCase().includes(filter.value)
    )
  } else {
    filteredGearArray.value = gearArray.value
  }
}

const sortedGearArray = computed(() => {
  return filteredGearArray.value.slice().sort((a, b) => {
    if (sortKey.value === 'gearId') {
      return a.gearId - b.gearId
    } else if (sortKey.value === 'name') {
      return a.name.localeCompare(b.name)
    } else if (sortKey.value === 'type') {
      return a.type.localeCompare(b.type)
    } else if (sortKey.value === 'vintage') {
      return a.vintage === b.vintage ? 0 : a.vintage ? -1 : 1
    }
  })
})

onMounted(getGearItems)
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
          <div class="sortandsearch fade-in">
            <div class="sortContainer">
              <label for="sort"></label>
              <select v-model="sortKey" id="sort">
                <option value="gearId">ID</option>
                <option value="name">Name</option>
                <option value="type">Type</option>
                <option value="vintage">Vintage</option>
              </select>
            </div>
            <SearchBox @search="filterGearItems" />
          </div>
        </div>
      </div>
    </header>

    <div class="cardscontainer">
      <GearCards :gearArray="sortedGearArray" />
    </div>
  </main>
</template>

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
  animation: fadeIn 0.2s ease-in-out;
}
.sortandsearch {
  display: flex;
  width: 32%;
}

.sortContainer {
  display: flex;
  padding-left: 10px;
  padding-right: 10px;
  flex-shrink: 1;
}

.h4title {
  display: flex;
  font-family: 'Jura';
  font-size: 1.4rem;
  color: rgba(0, 0, 0, 0.638);
  padding: 3px;
  width: 100%;
  flex-grow: 6;
  align-items: center;
  justify-content: center;
  padding-left: 3.5%;
}

.cardscontainer {
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

.controls {
  margin: 10px 0;
}

select {
  padding: 5px;
  font-family: 'Jura';
  border-radius: 6px;
  font-size: 0.75rem;
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
