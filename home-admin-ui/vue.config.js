const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true,
    configureWebpack: {
        devServer: {
            headers: {
                'Access-Control-Allow-Origin': '*' // 允许跨域访问
            }
        }
    },
    devServer: {
        proxy: {
            '^/api': {
                target: 'http://192.168.5.137:8080', // 后端服务器地址
                changeOrigin: true,
                pathRewrite: {
                    '^/api': '' // 可根据实际情况进行配置
                }
            },
            '^/nacos': {
                target: 'http://192.168.5.137:8848/nacos', // 后端服务器地址
                changeOrigin: true,
                pathRewrite: {
                    '^/nacos': '' // 可根据实际情况进行配置
                }
            },
            '^/seata': {
                target: 'http://192.168.5.137:7091', // 后端服务器地址
                changeOrigin: true,
                pathRewrite: {
                    '^/seata': '' // 可根据实际情况进行配置
                }
            },
            '^/minio': {
                target: 'http://192.168.5.137:9000', // 后端服务器地址
                changeOrigin: true,
                pathRewrite: {
                    '^/minio': '' // 可根据实际情况进行配置
                }
            },
        }
    }
})
