import {menuRouter} from './router';

export  default  {

    install(Vue){
        let list = [];
        for(let i = 0; i < menuRouter.length; i++){
            if( undefined != menuRouter[i].role && null != menuRouter[i].role ){
                list.push(menuRouter[i]);
            }
        }
        Vue.prototype.$MenuList = list;
    }

};
