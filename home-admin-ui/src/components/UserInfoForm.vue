<template>
    <div>
        <!-- 用户数据表格 -->
        <el-table
                :data="usersData"
                stripe
                border
                style="width: 100%">
            <el-table-column label="ID" prop="id"></el-table-column>
            <el-table-column label="姓名" prop="name"></el-table-column>
            <el-table-column label="邮箱" prop="email"></el-table-column>
            <el-table-column label="手机号" prop="phone"></el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button type="primary" size="mini" @click="editUser(scope.row)">编辑</el-button>
                    <el-button type="danger" size="mini" @click="deleteUser(scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <!-- 编辑用户对话框 -->
        <el-dialog
                title="编辑用户"
                :visible.sync="editDialogVisible"
                width="30%">
            <el-form :model="editUserForm" ref="editUserForm" label-width="80px">
                <el-form-item label="ID" prop="id">
                    <el-input v-model="editUserForm.id" disabled></el-input>
                </el-form-item>
                <el-form-item label="姓名" prop="name">
                    <el-input v-model="editUserForm.name"></el-input>
                </el-form-item>
                <el-form-item label="邮箱" prop="email">
                    <el-input v-model="editUserForm.email"></el-input>
                </el-form-item>
                <el-form-item label="手机号" prop="phone">
                    <el-input v-model="editUserForm.phone"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="editDialogVisible = false">取消</el-button>
                <el-button type="primary" @click="saveEditUser">保存</el-button>
            </div>
        </el-dialog>

        <!-- 添加用户按钮 -->
        <el-button type="primary" style="margin-top: 10px" @click="addUser">添加用户</el-button>
    </div>
</template>

<script>
import {mapMutations} from 'vuex';
import {MessageBox, Notification} from 'element-plus';

export default {
    data() {
        return {
            usersData: [], // 用户数据
            editDialogVisible: false, // 编辑用户对话框是否可见
            editUserForm: { // 编辑用户表单数据
                id: '',
                name: '',
                email: '',
                phone: '',
            },
        };
    },
    methods: {
        // 编辑用户
        editUser(user) {
            this.editUserForm = {...user};
            this.editDialogVisible = true;
        },
        // 保存编辑用户
        saveEditUser() {
            // 调用 GraphQL API 更新用户数据
            this.$apollo.mutate({
                mutation: gql`
          mutation updateUser($id: ID!, $input: UserInput) {
            updateUser(id: $id, input: $input) {
              id
              name
              email
              phone
            }
          }
        `,
                variables: {
                    id: this.editUserForm.id,
                    input: {
                        name: this.editUserForm.name,
                        email: this.editUserForm.email,
                        phone: this.editUserForm.phone,
                    },
                },
            }).then(response => {
                // 更新用户数据表格中的用户信息
                const index = this.usersData.findIndex(user => user.id === response.data.updateUser.id);
                this.usersData.splice(index, 1, response.data.updateUser);
                // 关闭编辑用户对话框
                this.editDialogVisible = false;
                // 提示保存成功
                Notification.success({
                    title: '成功',
                    message: '用户信息已保存',
                });
            }).catch(error => {
                // 提示保存失败
                Notification.error({
                    title: '错误',
                    message: '保存用户信息失败，请稍后再试',
                });
                console.error(error);
            });
        },
// 删除用户
        deleteUser(user) {
            // 弹出确认对话框
            MessageBox.confirm(`确认删除用户 "${user.name}" 吗？`, '提示', {
                type: 'warning',
                confirmButtonText: '删除',
                cancelButtonText: '取消',
            }).then(() => {
                // 调用 GraphQL API 删除用户数据
                this.$apollo.mutate({
                    mutation: gql`
        mutation deleteUser($id: ID!) {
          deleteUser(id: $id)
        }
      `,
                    variables: {
                        id: user.id,
                    },
                }).then(() => {
                    // 从用户数据表格中移除被删除的用户
                    const index = this.usersData.findIndex(u => u.id === user.id);
                    this.usersData.splice(index, 1);
                    // 提示删除成功
                    Notification.success({
                        title: '成功',
                        message: '用户已删除',
                    });
                }).catch(error => {
                    // 提示删除失败
                    Notification.error({
                        title: '错误',
                        message: '删除用户失败，请稍后再试',
                    });
                    console.error(error);
                });
            }).catch(() => {
                // 取消删除操作
            });
        },
// 添加用户
        addUser() {
            // 清空编辑用户表单数据
            this.editUserForm = {
                id: '',
                name: '',
                email: '',
                phone: '',
            };
            // 打开编辑用户对话框
            this.editDialogVisible = true;
        },
// Vuex mutations
        ...mapMutations('users', ['setUsers']),
    },
    mounted() {
// 调用 GraphQL API 获取用户数据
        this.$apollo.query({
            query: `gql query getUsers
        {
            users
            {
                id
                name
                email
                phone
            }
        }`
            ,
        }).then(response => {
// 将获取到的用户数据保存到 Vuex 中
            this.setUsers(response.data.users);
// 将用户数据赋值给 usersData
            this.usersData = [...response.data.users];
        }).catch(error => {
            console.error(error);
        });
    },
};
</script>

<style scoped>
.el-dialog__body {
    padding: 20px;
}
</style>

