### 简介:
    基于TypeScript, Vue, Spring boot的一个示例项目。
    本意是根据一个学校书籍阅读系统的一个例子，体验TS在实际项目中的使用。

### 相关整合:
    1. 基于vue-cli3.0搭建的vue-ts项目。
    2. 整合vue的路由控制。
    3. 整合axios, cookie相关所需要插件。
    4. 菜单的权限控制。
    5. ts全局变量调用声明
    6. Spring boot基础API项目
    7. Spring boot基础跨域配置
    8. 相关数据库结构及数据脚本。
    
### 项目内容:
    1. 用户登录
    2. 用户角色区分
        角色分为: 1. 管理员, 2.学生。
    3. 用户管理
        1. 管理员采取后台手动增加
        2. 学生采取页面控制新增
        3. 学生可以作废, 作废的学生不能登录
    4.书籍管理
        1. 管理员可以新增书籍和查看书籍。
        2. 学生只能查看书籍。
