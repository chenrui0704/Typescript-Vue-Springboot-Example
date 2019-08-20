import {menuRouter} from './router';

export  default  {

    install(Vue){
        let list = [];
        menuRouter.forEach(x => { undefined != x.role && null != x.role ? list.push(x) : null; });
        Vue.prototype.$MenuList = list;
    }

};
