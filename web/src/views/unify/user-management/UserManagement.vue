<style>
    .mT20{
        margin-top: 20px;
    }
    .mL20{
        margin-left: 20px;
    }
</style>
<template>
    <div>

        <Row class="mT20" my-description="按钮组">
            <Button @click="toAddStudent">新增学生</Button>
            <Button class="mL20" @click="queryAll">查询</Button>
        </Row>

        <Row my-description="表格">
            <Row class="mT20">
                <Table border :data="userData" :columns="userColumns"></Table>
            </Row>
            <Row class="mT20">
                <Page :total="queryParameter.total" :page-size="queryParameter.size" :current="queryParameter.index" @on-change="pageChange"></Page>
            </Row>
        </Row>


        <Row my-description="Modal弹框">
            <Modal title="新增学生" v-model="addStudentModal" @on-ok="addStudent">
                <Input v-model="operateUserInfo.name">
                    <span slot="prepend">学生名称</span>
                </Input>
                <Input class="mT20" v-model="operateUserInfo.loginName">
                    <span slot="prepend">登录名</span>
                </Input>
                <Input class="mT20" v-model="operateUserInfo.password">
                    <span slot="prepend">密码</span>
                </Input>
            </Modal>
        </Row>

    </div>
</template>

<script lang="ts">
    import {Component, Vue} from 'vue-property-decorator';
    import {UserInfo} from "../../../model/UserInfo";
    class QueryParameter extends UserInfo{
        index: number = 1;
        size: 10;
        total: 0;
    }

    @Component
    export default class UserManagement extends Vue{
        userColumns: any = [
            {
                key: 'name',
                title: '操作',
                width: 200,
                render: (h, parameter) =>{
                    let that = this;
                    let item = parameter.row;
                    let type = 'error';
                    let text = '作废';
                    let status = 1;
                    if(item.status == 1) {
                        text = '复用';
                        type = 'success';
                        status = 0;
                    }
                    let style = {
                        props:{
                            type: type
                        },
                        on:{
                            click:()=>{
                                that.operateStatus(status, item.id);
                            }
                        }
                    };
                    return h('Button', style, text);
                }
            },
            {
                key: 'name',
                title: '用户名',
                width: 200
            },
            {
                key: 'loginName',
                title: '登录名',
                width: 200
            },
            {
                key: 'inputTime',
                title: '录入时间',
                width: 200
            },
            {
                key: 'role',
                title: '角色',
                width: 200,
                render: (h, parameter)=> {
                    let item = parameter.row;
                    let text = '管理员';
                    if(item.role == 1){
                        text = '学生';
                    }
                    return h('span', text);
                }
            },
        ];
        userData: any = [];
        addStudentModal: boolean = false;
        operateUserInfo: UserInfo = new UserInfo();
        currentUserInfo: UserInfo = new UserInfo();
        queryParameter: QueryParameter = new QueryParameter();

        created(){
            this.currentUserInfo = JSON.parse(this.$Cookies.get('userinfo'));
            this.queryAll();
        }

        operateStatus(status: number, id: number){
            let that = this;
            let userInfo = {
                status: status,
                id: id
            };
            that.$ajax.post(that.$address + 'userinfo/operateStatus',userInfo).then(re =>{
                that.queryAll();
            });

        }

        toAddStudent(){
            this.addStudentModal = true;
        }

        addStudent(){
            let that = this;
            that.operateUserInfo.inputId =  that.currentUserInfo.inputId;
            that.operateUserInfo.role = 1;
            that.operateUserInfo.status = 0;
            that.$ajax.post(that.$address + 'userinfo/add',that.operateUserInfo).then(re =>{
                that.queryAll();
            });
        }

        queryAll(){
            let that = this;
            that.$ajax.post(that.$address + 'userinfo/queryAll',that.queryParameter).then(response =>{
                console.log(response);
                if (response.data.code == 1000 && response.data.status.toLocaleLowerCase() == 'success') {
                    let data = response.data.data;
                    that.userData = data.list;
                    that.queryParameter.total = data.total;
                    that.queryParameter.index = that.queryParameter.index;
                } else {
                    let content = '状态码: ' + response.data.code + '<br/> 错误说明:' + response.data.description;
                    that.$Message.error(content);
                    that.userData = [];
                    that.queryParameter.total = 0;
                }
            });
        }

        pageChange(value){
            this.queryParameter.index = value;
            this.queryAll();
        }

    }
</script>

