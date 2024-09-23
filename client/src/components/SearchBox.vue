<template>
  <form @submit.prevent="onSubmit" class="searchcontainer fade-in">
    <input
      type="search"
      class="searchbox"
      v-model="query"
      placeholder="Search..."
      @input="onInput"
      id="searchField"
      name="searchField"
    />
    <button type="submit" class="searchbutton">Search</button>
  </form>
</template>

<script>
export default {
  data() {
    return {
      query: ''
    }
  },
  methods: {
    onInput() {
      this.$emit('search', this.query)
    },
    onSubmit() {
      this.$emit('search', this.query)
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
  animation: fadeIn .2s ease-in-out;
}
.searchcontainer {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 5px;
  padding-right: 10px;
}

.search {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding-right: 20px;
}
.searchbox {
  font-family: 'Jura';
  font-size: 1rem;
  border-width: 1px;
  border-color: black;
  border-radius: 6px;
  border-width: 0px;
  padding: 3px;
  width: 100px;
}
.searchbutton {
  font-family: 'Jura';
  font-size: 1rem;
  font-weight: 600;
  background-color: rgb(46, 45, 45);
  color: white;
  border-width: 0;
  border-radius: 6px;
  padding: 3px;
}
</style>
