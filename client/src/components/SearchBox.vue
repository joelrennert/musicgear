<template>
  <form @submit.prevent="onSubmit">
    <input type="search" v-model="query" placeholder="Search" @input="onInput" />
    <button type="submit">Search</button>
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
