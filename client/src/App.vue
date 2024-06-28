<script setup>
import { RouterView } from 'vue-router'
import LeftPanel from './components/LeftPanel.vue';
import TheFooter from './components/TheFooter.vue';
</script>

<template>
    <main>
<LeftPanel/>
<RouterView />
</main>
<TheFooter/>
</template>

<style scoped>


</style>
