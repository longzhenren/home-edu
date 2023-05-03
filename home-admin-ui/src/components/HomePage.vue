<template>
    <div>
        <el-header>
            <h1 style="color: #fff; margin: 0;">AMUR HOME 后台管理</h1>
            <el-select v-model="selectedWebsite" placeholder="选择管理平台" @change="onWebsiteChange">
                <el-option
                        v-for="website in websites"
                        :key="website.id"
                        :label="website.name"
                        :value="website.url"
                ></el-option>
            </el-select>
        </el-header>
        <el-main>
            <iframe ref="websiteViewer" class="website-viewer" :src="selectedWebsite"></iframe>
        </el-main>
    </div>
</template>

<script>
export default {
    name: 'HomePage',
    data() {
        return {
            selectedWebsite: '', // 当前选中的网站
            websites: [ // 网站数据，可根据需求自定义
                {id: 1, name: '服务注册发现中心', url: '/api/nacos'},
                {id: 2, name: '服务动态配置中心', url: '/api/nacos'},
                {id: 3, name: '服务健康监测中心', url: '/api/sw'},
                {id: 4, name: '服务性能监控中心', url: '/api/sw'},
                {id: 5, name: '服务性能监控中心', url: '/api/sw'},
                {id: 6, name: '分布式事务管理中心', url: '/api/seata'},
                {id: 7, name: '业务数据管理中心', url: '/api/admin'},
                {id: 8, name: '文件存储后台', url: '/api/minio'},
            ]
        };
    },
    methods: {
        populateIframe(iframe, headers) {
            const xhr = new XMLHttpRequest();
            xhr.open("GET", this.selectedWebsite);
            xhr.responseType = "blob";
            headers.forEach((header) => {
                xhr.setRequestHeader(header[0], header[1]);
            });
            xhr.onreadystatechange = () => {
                if (xhr.readyState === xhr.DONE) {
                    if (xhr.status === 200) {
                        iframe.src = URL.createObjectURL(xhr.response);
                    }
                }
            };
            xhr.send();
        },
        onWebsiteChange() {
            // 下拉选择框选项变化时触发的方法
            const iframe = this.$refs.websiteViewer; // 获取 iframe 元素
            const iframeWindow = iframe.contentWindow; // 获取 iframe 的 window 对象

            // 添加请求头
            const headers = new Headers();
            headers.append('Authorization', 'Bearer ' + localStorage.getItem('token'));
            // 可以添加更多的请求头

            // 发送带有请求头的请求
            iframeWindow.fetch(this.selectedWebsite, {headers})
                .then(response => {
                    console.log(response);
                    // 处理响应
                })
                .catch(error => {
                    console.log(error);
                    // 处理错误
                });

            // 在 iframe 中加载对应网址的内容
            this.$refs.websiteViewer.src = this.selectedWebsite;
        }
    }
};
</script>

<style scoped>
.el-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 20px;
    height: 60px;
    background-color: #333;
}

.el-header h1 {
    margin: 0;
}

.website-viewer {
    width: 100%;
    height: calc(100vh - 60px); /* 减去导航栏的高度 */
    border: none;
}
</style>
