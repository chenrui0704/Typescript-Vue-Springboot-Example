<style>
    #login{
        width: 100vw;
        height: 100vh;
        background-image: url("../../assets/image/login1.png") ;
        background-size: cover;
    }

    #login-body{
        width: 100%;
        height: 100%;
        visibility: visible;
        background: rgba(0,0,0,.3);
    }

    #login-content{
        position: absolute;
        width: 260px;
        height: 270px;
        text-align: center;
        top: 25vh;
        left:60vw;
        background: rgba(0,0,0,.5);
        box-shadow: darkgrey 15px 10px 50px 15px ;

    }

    #loginbox{
        width: 80%;
        height: 80%;
        text-align: center;
        margin: 0 auto;
        margin-top: 40px;
        font-size: 18px;
        color: white;
    }

    .margin-top-20{
        margin-top: 20px;
    }

    @keyframes login {
        from { opacity: 1; }/* 开始 */
        50%  { opacity:   0.9; }/* 进度50% */
        to   { opacity: 1; }/* 结束 */
    }

    #login-introduction{
        position: absolute;
        width: 700px;
        height: 270px;
        top: 24vh;
        left:10vw;
        color: white;
    }

</style>
<template>
    <div id="login">
        <div id="login-body">
            <div id="login-content">
                <div id="loginbox">
                    <Row><span>登录</span></Row>
                    <Row class="margin-top-20">
                        <Input v-model="userInfo.loginName" prefix="ios-contact" placeholder="请输入登录名称" style="width: auto" clearable />
                    </Row>
                    <Row class="margin-top-20">
                        <Input v-model="userInfo.password" prefix="ios-lock" placeholder="请输入账户密码" type="password" style="width: auto"  clearable />
                    </Row>
                    <Row class="margin-top-20">
                        <Button type="default" style="width: 90%;" ghost  @click="login()"  >登录</Button>
                    </Row>
                </div>
            </div>
            <div id="login-introduction">
                <h1 style="font-weight: bold;font-size: 65px;" v-html="introductionTop"></h1>
                <p style="font-size: 50px;" v-html="introductionBottom"></p>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
    import {Vue,Component} from 'vue-property-decorator';
    import {UserInfo} from "../../model/UserInfo";

    @Component
    export default class Login extends Vue{

        userInfo: UserInfo = new UserInfo();
        introductionTop: string = '';
        introductionBottom: string = '';

        mounted() {
            let that = this;
            document.onkeydown = function (e) {
                if(e.key == 'Enter'){
                    that.login();
                }
            }
        };

        login(): void{
            let that = this;
            that.$ajax.post(that.$address + 'userinfo/login',that.userInfo,that.$ajaxJsonConfig).then(re => {
                console.log(re);
                let data = re.data;
                if(data.code == 1000){
                    that.$Cookies.set('userinfo', data.data);
                    that.$router.push('home');
                }else{
                    that.$Message.error(data.description);
                }
            });
        };

    }


</script>


