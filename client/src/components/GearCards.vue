<template>
  <article v-for="item in gearArray" :key="item.gearId" class="itemCard fade-in">
    <ul>
      <div class="name">
        <h4>{{ item.name }}</h4>
      </div>
      <li class="image">
        <div class="image-container">
          <img :src="getImageSrc(item.type)" width="110px" height="110px" />
        </div>
      </li>
      <li>
        <div class="type">{{ item.type }}</div>
      </li>
      <li>
        <div class="description">{{ item.description }}</div>
      </li>
      <li>
        <div class="isVintage">Vintage: {{ item.vintage ? 'Yes' : 'No' }}</div>
      </li>
      <div class="tools">
        <img
          src="/src/assets/pencil-svgrepo-com.svg"
          v-on:click="updateGearItem(item.gearId)"
          class="update"
          height="20"
        />
        <img
          src="/src/assets/trashcan-svgrepo-com.svg"
          v-on:click="deleteGearItemById(item.gearId)"
          class="delete"
          height="20"
        />
      </div>
    </ul>
  </article>
</template>

<script>
import MusicGearService from '@/services/MusicGearService'

export default {
  props: {
    gearArray: {
      type: Array,
      required: true
    }
  },
  methods: {
    getImageSrc(type) {
      const imageMap = {
        Guitar: '/src/assets/equaliser-svgrepo-com.svg',
        Synthesizer: '/src/assets/synthesizer.svg',
        Audio: '/src/assets/equaliser-svgrepo-com.svg',
        Midi: '/src/assets/server.svg',
        Mic: '/src/assets/pencil-svgrepo-com.svg',
        default: '/src/assets/audio.svg'
      }
      return imageMap[type] || imageMap.default
    },
    deleteGearItemById(gearId) {
      this.isLoading = true
      MusicGearService.deleteGearItemById(gearId).then((response) => {
        if (response.status === 204) {
          console.log('ITEM DELETED')
          location.reload()
        }
      })
    },
    updateGearItem(gearId) {
      this.$router.push({ name: 'update', params: { gearId } })
    }
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
  animation: fadeIn 0.2s ease-in-out;
}
body {
  display: flex;
  overflow: auto;
}

h5 {
  font-style: italic;
}

ul {
  padding: 0px;
}

li {
  display: flex;
  flex-wrap: wrap;
  list-style: none;
  padding: 5px;
}

.delete,
.update {
  cursor: pointer;
}

.tools {
  display: flex;
  justify-content: right;
  align-items: baseline;
  padding: 10px;
  gap: 5px;
  flex-grow: 1;
}

.itemCard {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  border-radius: 6px;
  padding: 5px;
  margin: 10px;
  width: 22%;
  color: rgb(0, 0, 0);
  background: rgba(255, 255, 255, 0);
  border-radius: 20px;
  backdrop-filter: blur(5px);
  -webkit-backdrop-filter: blur(5px);
  border: 1px solid rgb(255, 255, 255);
  box-shadow: 5px 5px 6px 2px rgba(0, 0, 0, 0.2);
  /* background: rgb(206, 245, 243);
  background: linear-gradient(
    90deg,
    rgba(206, 245, 243, 0.249) 0%,
    rgba(241, 251, 229, 0.253) 53%,
    rgba(206, 245, 243, 0.259) 100%
  ); */
}

.name {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  font-size: 1rem;
  color: black;
  font-family: 'Jura';
  background-color: rgba(255, 255, 255, 0.23);
  padding: 6px;
  border-radius: 10px;
}

.name,
.type,
.description,
.isVintage {
  display: flex;
  flex-direction: column;
  align-items: left;
  justify-content: space-evenly;
  flex-wrap: wrap;
  font-weight: 400;
}

.image {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px;
}

.image-container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100px;
  height: 100px;
}
</style>
