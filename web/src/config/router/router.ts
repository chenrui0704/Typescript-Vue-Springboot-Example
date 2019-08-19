import Alone from '../../views/component/Alone.vue';
import Unify from '../../views/component/Unify.vue';
import RootPage from '../../views/component/RootPage.vue';

// 独立样式的组件
export const aloneRouter = {
    path: '/alone',
    component: Alone,
    children: [
        { name: 'login', path: '/login', component: ()=> import('@/views/alone/Login.vue') },
    ]
};

// 统一样式的组件不在菜单栏显示
export const unifiedRouter = {
    path: '/unify',
    component: Unify,
    children: [
    
    ]
};

// 统一样式的组件在菜单栏显示
export const menuRouter = [
    {
        path: '/home',
        component: Unify,
        role: [0, 1],
        title:'首页',
        name:'home',
        children: [
            {name:'home',path: '/home',component:()=> import("../../views/unify/home-page/Home.vue") },
        ]
    },
    {
        path: '/user',
        component: Unify,
        role: [0],
        title:'用户管理',
        name:'user',
        children: [
            {name:'userManagement',path: '/userManagement',component:()=> import("../../views/unify/user-management/UserManagement.vue") },
        ]
    },
    {
        path: '/book',
        component: Unify,
        role: [0, 1],
        title:'书籍管理',
        name:'book',
        children: [
            {name:'bookManagement',path: '/bookManagement',component:()=> import("../../views/unify/book-management/BookManagement.vue") },
        ]
    },
];

// 根路由
export const rootRouter = { path:'/', component: RootPage,name:'root' };

export default [aloneRouter, unifiedRouter, rootRouter, ...menuRouter];
