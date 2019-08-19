
/**
 * 时间: 2019年7月26日 17:44:21
 * 创建人: Cr
 * 声明全局变量，如果不进行声明的话。也是可以用的，但是ts会识别不出来。
 * */
declare module 'Vue/types/vue' {
    interface Vue {
        $ajax: any;
        $address:string;
        $ajaxJsonConfig: any;
        $Cookies: any;
        $MenuList: any;
    }
}
export default {}
