<template>
    <div>
        <el-dialog v-model="dialogVisible" title="编辑数据" @close="handleCloseDialog"
            @update:visible="handleDialogVisibleUpdate">
            <el-form ref="form" :model="jsonObject" label-width="100px">
                <el-form-item label="JSON对象">
                    <el-input type="textarea" v-model="jsonObjectString" :rows="24"
                        :autosize="{ minRows: 12, maxRows: 24 }"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleSave">保存</el-button>
                    <el-button @click="handleCancel">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
        <!-- 表格名下拉框 -->
        <el-select v-model="selectedTable" @change="handleTableChange">
            <el-option v-for="table in tables" :key="table.name" :label="table.name" :value="table.name"></el-option>
        </el-select>
        <!-- 表格组件 -->
        <el-table :data="tableData" v-loading="loading" @filter-change="handleFilter">
            <!-- 表格列 -->
            <el-table-column v-for="column in columns" :key="column.prop" :prop="column.prop" :label="column.label">
                <!-- 列名筛选组件 -->
                <template v-slot:header>
                    <div style="display: grid; place-items: center; overflow: auto;">
                        {{ column.label }}
                    </div>
                    <div style="display: grid; place-items: center;">
                        <el-input v-model="filterValue[column.prop]" size="small" @input="handleFilterInput(column, $event)"
                            placeholder="值" clearable>
                        </el-input>
                        <el-select v-model="filterOperation[column.prop]" size="small"
                            @change="handleFilterChange(column, $event)" placeholder="条件" clearable>
                            <el-option label="包含" value="like"></el-option>
                            <el-option label="等于" value="eq"></el-option>
                            <el-option label="不等于" value="ne"></el-option>
                            <!--                            <el-option label="等于" value="eq"></el-option>-->
                            <!-- 其他筛选操作逻辑选项... -->
                        </el-select>
                    </div>
                </template>
            </el-table-column>
            <!-- 操作列：修改、删除按钮 -->
            <el-table-column>
                <template v-slot:header>
                    <div style="display: flex; justify-content: center; align-items: flex-end;">
                        <div style="display: flex;">
                            <el-button size="small" type="primary" @click="handleFilter">筛选</el-button>
                            <el-button size="small" type="primary" @click="handleAdd" style="margin-left: 10px;">新增
                            </el-button>
                        </div>
                    </div>
                </template>

                <template v-slot:default="scope">
                    <div style="display: flex; justify-content: flex-end; align-items: center;">
                        <el-button type="primary" size="small" @click="handleEdit(scope.row)">修改</el-button>
                        <el-button type="danger" size="small" @click="handleDelete(scope.row)" style="margin-left: 10px;">删除
                        </el-button>
                    </div>
                </template>
            </el-table-column>
        </el-table>

        <!-- 分页器 -->
        <el-pagination v-model="currentPage" :page-sizes="[10, 20, 30, 40]" :page-size="pageSize" :total="totalRows"
            layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange"
            @current-change="handlePageChange">
        </el-pagination>
    </div>
</template>

<script>
import { reactive } from "vue";

export default {
    props: {
        scope: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            tables: [
                {
                    name: 'home_info',
                    api: '/api/home-user/admin/home',
                    columns: [{ prop: 'id', label: 'ID' }, { prop: 'name', label: '家庭名称' }, {
                        prop: 'description',
                        label: '描述'
                    }, { prop: 'avatarUrl', label: '头像URL' }, {
                        prop: 'imageUrls',
                        label: '图片URLs'
                    }, { prop: 'adminIds', label: '管理员ID' }, {
                        prop: 'createUserId',
                        label: '创建用户ID'
                    }, { prop: 'memberIds', label: '成员ID' }, {
                        prop: 'likeCount',
                        label: '点赞数'
                    }, { prop: 'favCount', label: '收藏数' }, { prop: 'open', label: '是否公开' }, {
                        prop: 'createTime',
                        label: '创建时间'
                    }, { prop: 'updateTime', label: '更新时间' },]
                }, {},
            ],
            selectedTable: '',
            columns: [],
            tableData: [],
            loading: false,
            currentPage: 1,
            pageSize: 10,
            totalRows: 0,
            // filterParams: {},
            sortField: 'id',
            sortOrder: 'asc',
            filterValue: {},
            filterOperation: {},
            apiPrefix: '',
            dialogVisible: false,
            jsonObjectString: '',
            jsonObject: {},
        };
    },
    // mounted() {
    //     // 页面加载时默认选择第一个表格
    //
    // },
    methods: {
        handleDialogVisibleUpdate(visible) {
            // 更新对话框可见性
            this.dialogVisible = visible;
            // 如果对话框关闭，还需要重置 jsonObject 和 jsonObjectString 数据
            if (!visible) {
                this.jsonObject = null;
                this.jsonObjectString = '';
            }
        },
        handleEdit(row) {
            this.dialogVisible = true;
            this.jsonObjectString = JSON.stringify(row, null, 2);
            this.jsonObject = reactive(JSON.parse(this.jsonObjectString));
        },
        handleCloseDialog() {
            this.dialogVisible = false;
        },
        handleSave() {
            try {
                const parsedObject = JSON.parse(this.jsonObjectString);
                this.jsonObject = reactive(parsedObject);
                // 在这里可以将编辑后的 JSON 对象保存到服务器或进行其他操作
                this.$emit('update', this.jsonObject); // 发送自定义事件，传递更新后的 JSON 对象
                this.dialogVisible = false;
            } catch (error) {
                this.$message.error('JSON格式错误，请检查输入！');
            }
        },
        handleCancel() {
            this.dialogVisible = false;
        },
        // 处理表格名下拉框的选择
        handleTableChange() {
            // 根据选择的表格名更新表格列信息
            const selectedTable = this.tables.find(table => table.name === this.selectedTable);
            console.log(selectedTable)
            if (selectedTable) {
                this.columns = selectedTable.columns;
                // 清空筛选条件和表格数据
                // this.filterParams = {};
                this.filterValue = {};
                this.filterOperation = {};
                this.tableData = [];
                this.totalRows = 0;
                this.apiPrefix = selectedTable.api;
            }
        },
        // 处理表格列名筛选输入框的输入
        handleFilterInput(column, value) {
            // console.log(this.filterValue)
            // console.log(value)
            if (value === "null") {
                this.filterValue[column.prop] = null;
            }
            this.filterValue[column.prop] = value;
            console.log(this.filterValue)
            // this.filterParams[column.prop]["value"] = event.target.value;
            // console.log(this.filterParams)
        },
        // 处理表格列名筛选操作逻辑下拉框的选择
        handleFilterChange(column, value) {
            if (value === "none") {
                this.filterOperation[column.prop] = null;
            }
            this.filterOperation[column.prop] = value;
            console.log(this.filterOperation)
            // this.filterParams[column.prop]["match"] = value;
            // console.log(this.filterParams)
        },
        // 处理分页器每页行数的选择
        handleSizeChange(size) {
            this.pageSize = size;
            // 调用后端接口获取对应页数的表格数据
            this.fetchTableData();
        },
        // 处理分页器页码的选择
        handlePageChange(page) {
            this.currentPage = page;
            // 调用后端接口获取对应页数的表格数据
            this.fetchTableData();
        },
        // 处理新增按钮的点击
        handleAdd() {
            // 弹出新增表格数据的对话框
            // 此处为示例代码，仅模拟前端新增功能
            this.$message.success('新增成功');
        },
        // 处理修改按钮的点击
        // handleEdit() {
        //     // handleEdit(row) {
        //     // 弹出修改表格数据的对话框
        //     // 此处为示例代码，仅模拟前端修改功能
        //     this.$message.success('修改成功');
        // },
        // 处理删除按钮的点击
        handleDelete() {
            // handleDelete(row) {
            // 调用后端接口删除表格数据
            // 此处为示例代码，仅模拟前端删除功能
            this.$message.success('删除成功');
        },
        // 调用后端接口获取表格数据
        fetchTableData() {
            // 根据当前页码和每页行数调用后端接口获取表格数据
            this.loading = true;
            // console.log(this.filterParams)
            const filterParams = {};
            for (const column of this.columns) {
                const key = column.prop;
                // 创建包含 "match" 和 "value" 字段的内部 Map 对象
                if (this.filterOperation[key] === undefined) {
                    // this.filterOperation[key] = 'like';
                    continue
                }
                if (this.filterValue[key] === undefined) {
                    // this.filterValue[key] = '';
                    continue
                }
                filterParams[key] = {
                    "match": this.filterOperation[key],
                    "value": this.filterValue[key]
                };
            }
            console.log(filterParams)
            //axios调用后端接口获取表格数据
            this.axios.post(this.apiPrefix + '/query',
                {
                    "params": filterParams,
                    "sortField": this.sortField,
                    "sortOrder": this.sortOrder,
                    "pageNo": this.currentPage,
                    "pageSize": this.pageSize
                }
                , {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                        'Authorization': 'Bearer ' + localStorage.getItem('token')
                    }
                })
                .then(response => {
                    console.log(response.data);
                    this.tableData = response.data.records;
                    this.totalRows = response.data.total;
                    this.loading = false;
                }).catch(error => {
                    console.log(error);
                    this.loading = false;
                });
        },
        // 处理表格列名筛选按钮的点击
        handleFilter() {
            this.fetchTableData();
        },
    },
    created() {
        if (this.tables.length > 0) {
            console.log(this.tables[0])
            this.selectedTable = this.tables[0].name;
        }
        // 初始化表格名和表格列信息
        this.handleTableChange();
        // 初始化表格数据
        this.fetchTableData();
    }
};
</script>
