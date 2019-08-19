import router from './router';
import VueRouter from 'vue-router';
import Vue from 'vue';

Vue.use(VueRouter);

export const routers = new VueRouter({routes:router});

// 控制判断
routers.beforeEach(( to, from, next ) => {
    next();
});

export  default routers;
