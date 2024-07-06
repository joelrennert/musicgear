import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AboutView from '../views/AboutView.vue'
import AddGearItemView from '../views/AddGearItemView.vue'
import UpdateGearItemView from '../views/UpdateGearItemView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    redirect: { name: 'musicgear' }
  },
  {
    path: '/musicgear',
    name: 'musicgear',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    component: AboutView
  },
  {
    path: '/add',
    name: 'add',
    component: AddGearItemView
  },
  {
    path: '/update/:gearId',
    name: 'update',
    component: UpdateGearItemView,
    props: true
  }
]

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
})

// const router = createRouter({
//   history: createWebHistory(import.meta.env.BASE_URL),
//   routes: routes,
//   });

export default router
