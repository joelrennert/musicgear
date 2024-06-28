<script setup></script>

<template>
  <main>
    <div class="container">
    <GearCards v-bind:gearArray="gearArray" />
  </div>
  </main>
</template>

<script>
import GearCards from '../components/GearCards.vue'
import MusicGearService from '../services/MusicGearService'

export default {
  components: {
    GearCards
  },
  data() {
    return {
      gearArray: []
    }
  },

  methods: {
    getGearItems() {
      MusicGearService.list()
        .then((response) => {
          this.gearArray = response.data
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
      //
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
  flex-wrap:wrap;
  width: 80vw;
  margin-top: 20px;
  margin-bottom:25px;

  
}
main {
  display: flex;
  
  /* width: 90vw; */
  /* flex-direction: row; */
  /* justify-content: space-evenly; */
}
</style>
