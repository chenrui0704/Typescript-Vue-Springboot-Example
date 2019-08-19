import Vue from 'vue';
let env = process.env.NODE_ENV;
console.log('process.env.NODE_ENV : ',env);

let address = 'http://192.168.17.195:7420/';

if(env != 'development'){
    address = 'http://180.167.43.197:7520/';
}

const Address = {
    install(){
        Vue.prototype.$address = address;
    }
};

export default Address;
