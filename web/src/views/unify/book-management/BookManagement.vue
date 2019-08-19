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
            <Button v-if="currentUserInfo.role == 0" class="mL20" @click="toAddBook">新增</Button>
            <Button class="mL20" @click="queryAll">查询</Button>
        </Row>
        <Row class="mT20"  my-description="表格">
            <Table border :data="data" :columns="columns"></Table>
        </Row>
        <Row my-description="Modal弹框">
            <Modal title="新增书籍" v-model="addBookModal" @on-ok="addBook">
                <Input v-model="operateBook.name">
                    <span slot="prepend">书籍名称</span>
                </Input>
                <Input class="mT20" v-model="operateBook.title">
                    <span slot="prepend">书籍标题</span>
                </Input>
            </Modal>
        </Row>
    </div>
</template>

<script lang="ts">
    import {Component, Vue} from 'vue-property-decorator';
    import  Columns from './Columns';
    import {UserInfo} from "../../../model/UserInfo";
    import Book from "../../../model/Book";

    @Component
    export default class BookManagement extends Vue{
        addBookModal: boolean = false;
        data: any = [];
        columns: any = Columns;
        currentUserInfo: UserInfo = new UserInfo();
        operateBook: Book = new Book();

        created(){
            this.currentUserInfo = JSON.parse(this.$Cookies.get('userinfo'));
            this.operateBook.inputId =  this.currentUserInfo.inputId;
            this.queryAll();
        }

        queryAll(){
            let that = this;
            that.$ajax.post(that.$address + 'book/queryAll',{}).then(re =>{
                that.data = re.data;
            });
        }

        addBook(){
            let that = this;
            that.$ajax.post(that.$address + 'book/add',that.operateBook).then(re =>{
                that.queryAll();
            });
        }

        toAddBook(){
            this.addBookModal = true;
        }

    }

</script>
