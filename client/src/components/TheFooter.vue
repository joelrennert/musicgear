<template>
  <footer>
    <div class="container1">
      🫠 JOEL RENNERT 2024 》
      <a href="https://joelrennert.github.io/portfolio/" target="_blank">portfolio</a>
      》<a href="https://github.com/joelrennert" target="_blank">github</a> 》<a
        href="https://www.linkedin.com/in/joelrennert/"
        target="_blank"
        >linkedin</a
      >
    </div>
    <div class="container2">
      <span class="emoji">🍄</span>
    </div>
  </footer>
</template>

<script>
export default {}
</script>

<style scoped>
.emoji {
  display: inline-block;
}

.emoji:hover {
  animation: centeredBouncy 0.5s ease;
  cursor: pointer;
}

@keyframes centeredBouncy {
  0% {
    transform: scale(1);
  }
  30% {
    transform: scale(1.1);
  }
  50% {
    transform: scale(1.95);
  }
  70% {
    transform: scale(1.05);
  }
  100% {
    transform: scale(1);
  }
}

.container1 {
  display: flex;
  align-items: center;
  gap: 10px;
}

.container2 {
  display: flex;
  align-items: center;
}

footer {
  font-family: 'IBM Plex Mono';
  z-index: 1;
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100vw;
  height: 20px;
  bottom: 0;
  left: 0;
  background-color: white;
  position: fixed;
  border-style: solid;
  border-color: black;
  border-width: 1px;
  border-top-left-radius: 15px;
  border-top-right-radius: 15px;
  padding: 12px;
  font-size: 0.8rem;
}

a {
  color: black;
}



</style>
