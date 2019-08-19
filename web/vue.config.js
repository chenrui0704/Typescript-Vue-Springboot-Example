module.exports = {
    // 基本路径
    baseUrl: '/',
    // 在npm run build 或 yarn build 时 ，生成文件的目录名称
    outputDir: 'my-ts-vue',
    //  用于放置生成的静态资源 (js、css、img、fonts) 的；（项目打包之后，静态资源会放在这个文件夹下）
    assetsDir: "assets",
    // eslint-loader 是否在保存的时候检查
    lintOnSave: false,
    // 生产环境是否生成 sourceMap 文件
    productionSourceMap: false,

    // css相关配置
    css: {
        // 是否使用css分离插件 ExtractTextPlugin
        extract: false,
        // 开启 CSS source maps?
        sourceMap: false,
        // css预设器配置项
        loaderOptions: {},
        // 启用 CSS modules for all css / pre-processor files.
        modules: false
    },
    // 在生产版本中为babel&ts使用线程加载器.默认情况下，如果机器有多个核心，则启用线程加载器
    parallel: require('os').cpus().length > 1,
    // PWA 插件相关配置
    pwa: {},
    // 开发环境相关配置
    devServer: {
        open: process.platform === 'dev',
        host: '0.0.0.0',
        port: 7421,
        https: false,
        hotOnly: false,
        proxy: null, // 设置代理
        before: app => {}
    },
    // 第三方插件配置
    pluginOptions: {
        // ...
    }
}
