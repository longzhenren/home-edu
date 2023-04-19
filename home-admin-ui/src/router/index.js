import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '@/components/HomePage.vue';  // 导入页面组件
import LoginPage from '@/components/LoginPage.vue';  // 导入页面组件
import FormPage from '@/components/FormPage.vue';  // 导入页面组件


const routes = [
    {
        path: '/home',
        component: HomePage  // 配置路由路径和对应的页面组件
    },
    {
        path: '/login',
        component: LoginPage  // 配置路由路径和对应的页面组件
    },
    {
        path: '/',
        component: LoginPage  // 配置路由路径和对应的页面组件
    },
    {
        path: '/Form',
        component: FormPage  // 配置路由路径和对应的页面组件
    }
    // 可以继续配置其他路由
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
