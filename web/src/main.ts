import Vue from 'vue';
import Alone from './views/component/Alone.vue';
import router from './config/router/routerControl';
import store from './config/store/store'
import axios  from 'axios';
import address  from './config/constant/address';
import iView from 'iview';
import 'iview/dist/styles/iview.css';
import Cookies from 'js-cookie';
import menuControl from './config/router/menuControl';

Vue.prototype.$Cookies = Cookies;
Vue.prototype.$ajax = axios;
Vue.prototype.$ajaxJsonConfig = {
    headers: {'Content-Type': 'application/json;charset=UTF-8'}
};

Vue.use(address);
Vue.use(iView);
Vue.use(menuControl);

Vue.config.productionTip = false;

new Vue({
  el: '#app',
  router: router,
  store,
  render: h => h(Alone)
});
