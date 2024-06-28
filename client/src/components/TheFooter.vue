<template>
    <footer>
        <div class="container1">
        © JOEL RENNERT 2024 》
        <a href="#">unorb.com</a> 》<a href="#">github</a> 》<a href="#">linkedin</a>
        </div>
        <div class="container2">
        thanks for looking at my web app
        </div>
    </footer>
  </template>
  <script>
  export default {};
  </script>
  <style scoped>

.container2{
    display: flex;
    flex-grow: 1;
    justify-content:right;
    padding-right: 20px;
}
  footer {
    display: flex;
    /* justify-content: space-evenly; */
    align-items: center;
    width: 100%;
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
    padding:12px;
    font-size: 1rem;
    
  }
  </style>
  