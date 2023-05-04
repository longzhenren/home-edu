import {createApp} from 'vue';
import App from './App.vue';
import router from "./router/index.js";
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import axios from 'axios';
import vueAxios from 'vue-axios';

// axios.defaults.baseURL = 'http://192.168.5.137:8080'; // 设置 baseURL
axios.defaults.timeout = 5000; // 设置请求超时时间
// App.prototype.$axios = axios
const app = createApp(App)
app.use(router);
app.use(ElementPlus)
app.use(vueAxios, axios);
app.mount('#app')
