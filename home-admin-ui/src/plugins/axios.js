// import axios from 'axios';
// import { showMessage } from "./status";   // 引入状态码文件
// import { ElMessage, messageConfig } from 'element-plus'  // 引入el 提示框，这个项目里用什么组件库这里引什么
//
// // 设置接口超时时间
// // axios.defaults.timeout = 5000;
//
// // 请求地址，这里是动态赋值的的环境变量，下一篇会细讲，这里跳过
// // console.log("!!!",process.env.NODE_ENV)
// // if (process.env.NODE_ENV == 'development') {
// //     axios.defaults.baseURL = 'http://47.95.202.150:8009/';
// // } else if (process.env.NODE_ENV == 'production') {
// //     axios.defaults.baseURL = 'http://47.95.202.150:8008/';
// // }
//
//
// // axios.defaults.baseURL = import.meta.env.VITE_API_DOMAIN;
//
// axios.defaults.baseURL = 'http://47.95.202.150:8009/'
//
// //http request 拦截器
// axios.interceptors.request.use(
//     config => {
//         // 配置请求头
//         console.log(Object.prototype.toString.call(config.params)=== '[object FormData]' ||
//             Object.prototype.toString.call(config.data)=== '[object FormData]'
//         )
//         if(Object.prototype.toString.call(config.params)=== '[object FormData]' ||
//             Object.prototype.toString.call(config.data)=== '[object FormData]'
//         ){
//             config.headers = {
//                 'Content-Type':'multipart/form-data',
//             }
//         }else{
//             config.headers = {
//                 'Content-Type':'application/json;charset=UTF-8',
//             }
//         }
//
//         return config;
//     },
//     error => {
//         return Promise.reject(error);
//     }
// );
//
// //http response 拦截器
// axios.interceptors.response.use(
//     response => {
//         // const headers=response.headers
//         // if(headers['content-type'].includes("application/octet-stream")){
//         // }
//         return response;
//     },
//     error => {
//         const {response} = error;
//         if (response) {
//             // 请求已发出，但是不在2xx的范围
//             showMessage(response.status);
//             // 传入响应码，匹配响应码对应信息
//             return Promise.reject(response.data);
//         } else {
//             ElMessage.warning('网络连接异常,请稍后再试!');
//         }
//     }
// );
//
// // 封装 GET POST 请求并导出
// export function request(url='',params={},type='POST',forma='json'){
// //设置 url params type 的默认值
//     return new Promise((resolve,reject)=>{
//         let promise={}
//         if(forma.toUpperCase()==='JSON'){
//
//             if( type.toUpperCase()==='GET' ){
//                 promise = axios({
//                     url,
//                     params
//                 })
//             }else if( type.toUpperCase()=== 'POST' ){
//                 promise = axios({
//                     method:'POST',
//                     url,
//                     data:params
//                 })
//             }
//         }else if(forma.toUpperCase()==='FORM'){
//             if( type.toUpperCase()==='GET' ){
//                 promise = axios({
//                     url,
//                     params,
//                 })
//             }else if( type.toUpperCase()=== 'POST' ){
//                 promise = axios({
//                     method:'POST',
//                     url,
//                     data:params
//                 })
//             }
//         }
//
//         //处理返回
//         promise.then(res=>{
//             resolve(res)
//         }).catch(err=>{
//             reject(err)
//         })
//     })
// }