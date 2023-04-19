<template>
    <div class="login-container">
        <div class="login-bg"></div>
        <el-card class="login-card">
            <div class="login-logo">
                <!-- 这里可以放置登录页面的logo -->
                <h1>AMUR管理后台登录</h1>
            </div>
            <div class="login-form">
                <el-form ref="loginForm" :model="loginForm" :rules="loginRules" label-width="80px">
                    <el-form-item label="用户名" prop="username">
                        <el-input v-model="loginForm.username" placeholder="用户名"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input
                                v-model="loginForm.password"
                                type="password"
                                placeholder="密码"
                        ></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="login">登录</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </el-card>
    </div>
</template>

<script>

export default {
    name: 'LoginPage',
    data() {
        return {
            loginForm: {
                username: '',
                password: ''
            },
            loginRules: {
                username: [
                    {required: true, message: '请输入用户名', trigger: 'blur'}
                ],
                password: [
                    {required: true, message: '请输入密码', trigger: 'blur'}
                ]
            }
        };
    },
    methods: {
        login() {
            // 登录逻辑
            this.$refs.loginForm.validate(valid => {
                if (valid) {
                    // 进行登录操作，可在此处发送请求给后端进行验证
                    this.axios.post('/api/home-auth/login', this.loginForm, { headers: {'Content-Type': 'application/x-www-form-urlencoded'}})
                        .then(res => {
                            // 登录成功逻辑
                            console.log('Login success:', res.data);
                            this.$message.success('登录成功');

                            // 保存 token 到本地存储
                            localStorage.setItem('token', res.data.data.token.tokenValue);

                            // 设置请求头中的 Authorization 字段为 Bearer token
                            this.axios.defaults.headers.common['Authorization'] = 'Bearer ' + res.data.data.token.tokenValue;

                            // 进行页面跳转到主页
                            this.$router.push('/home'); // 替换成你的主页路径
                        })
                        .catch(err => {
                            // 登录失败逻辑
                            console.error('Login failed:', err);
                            this.$message.error('登录失败: ' + err.response.data.message);

                        });
                    console.log('Login form:', this.loginForm);
                } else {
                    return false;
                }
            });
        }
    }
};
</script>


<style scoped>
.login-container {
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

.login-bg {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-image: url('@/assets/login-bg.jpg'); /* 替换成你的背景图片路径 */
    background-size: cover;
    background-position: center;
    opacity: 0.7; /* 可根据需要调整背景图片透明度 */
    z-index: -1; /* 将背景图层级设为较低，以使登录页面内容在上层 */
}

.login-card {
    width: 360px;
    padding: 20px;
}

.login-logo {
    text-align: center;
    margin-bottom: 20px;
}

.login-form {
    margin-top: 20px;
}
</style>