import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AboutView from '../views/AboutView.vue';

const routes = [
  {
    path: '/',
    name: 'home',
    redirect: { name: "musicgear" },
  },
  {
    path: '/musicgear',
    name: 'musicgear',
    component: HomeView,
  },
  {
    path: '/about',
    name: 'about',
    component: AboutView,
  }
];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes,
});

// const router = createRouter({
//   history: createWebHistory(import.meta.env.BASE_URL),
//   routes: routes,
//   });


export default router;
