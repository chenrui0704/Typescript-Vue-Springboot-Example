<style>
    #header-main{
        width: 100%;
        height: 60px;
        position: fixed;
    }
    #header-body{
        width: 95%;
        height: 90%;
        margin: 0 auto;
    }
    #header-left{
        width: 40%;
        height: 50px;
        float: left;
    }
    #header-mid{
        width: 50%;
        height: 50px;
        float: left;

    }
    #header-right{
        width: 10%;
        height: 50px;
        float: left;
    }

    #body{
        margin-top: 60px;
        float: left;
        width: 100%;
        height: 100%;
    }

    #body-left {
        width: 200px;
        float: left;
        height: calc(100% - 50px);
        overflow-y: auto;
        position: fixed;
    }
    #body-right{
        width:auto;
        margin-left: 200px;
        font-size: 16px;
    }

    #introduction{
        float: left;
        margin-left: 20px;
        font-size: 20px;
        font-family: 'Microsoft YaHei UI';

    }

</style>

<template>
    <div id="main" style="width: 100%">
        <Affix>
            <Row>
                <div id="header-main">
                    <Card style="width:100%;height: 100%">
                        <div id="header-body">
                            <div id="header-left">
                                <div style="float: left;">
                                    <!-- top image-->
                                    <img src="https://file.iviewui.com/dist/e1cf12c07bf6458992569e67927d767e.png" style="height: 50px;margin-top: -10px;" />
                                </div>
                                <div id="introduction" v-html="introduction"></div>
                            </div>
                            <div id="header-mid"></div><!-- 暂时无内容 -->
                            <div id="header-right">
                                <Button type="primary" @click="signOut" ghost>退出</Button>
                            </div>
                        </div>
                    </Card>
                </div>
            </Row>
        </Affix>

        <Row id="body">
            <div id="body-left">
                <Menus></Menus>
            </div>
            <div id="body-right">
                <router-view/>
            </div>
        </Row>

    </div>
</template>

<script lang="ts">
    import { Component, Vue } from 'vue-property-decorator';
    import Menus from '@/views/component/Menus.vue';

    @Component({components:{Menus:Menus}})
    export default class Unify extends Vue{
        introduction:string =  'TypeScript + Vue的示例';

        signOut(){
            this.$Cookies.remove('userinfo');
            this.$router.push('login');
        }

    }

</script>
