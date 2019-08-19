package com.school.book.util;

/**
 * API接口请求返回的模型类
 *
 * @author cr
 * @date 2019-06-05
 */
public class MyResult {

    // 最先的版本如下，但是感觉不需要这样。
    /*private volatile static MyResult myResult;

    private MyResult() { }

    // 创建实例
    private synchronized static MyResult createInstance() {
        if (null == myResult) {
            synchronized (MyResult.class) {
                if (myResult == null) {
                    myResult = new MyResult();
                }
            }
        }
        return myResult;
    }*/

    private static MyResult myResult;

    private MyResult() {}

    // 创建实例
    private static MyResult createInstance() {
        if (null == myResult) {
            myResult = new MyResult();
        }
        return myResult;
    }

    // region 属性区

    /**
     * 服务名称
     */
    private String serviceName = "school-book-reading-system";

    /**
     * API请求的地址
     * 例如: /usc-zuul/base/user
     */
    private String path;

    /**
     * 请求状态
     */
    private String status;

    /**
     * 状态码
     */
    private String code;

    /**
     * 说明
     */
    private String description;

    /**
     * 返回的数据
     */
    private Object data;

    // endregion

    // region 返回调用区

    /**
     * 请求错误
     *
     * @date 2019-06-05
     * @author cr
     */
    public static MyResult error() {
        return init(null, BaseEnum.STATUS_ERROR.value, BaseEnum.DESCRIPTION_ERROR.value, BaseEnum.CODE_ERROR.value, null);
    }

    /**
     * 请求错误，设置错误说明
     *
     * @param description 说明
     * @date 2019-06-05
     * @author cr
     */
    public static MyResult error(String description) {
        return init(null, BaseEnum.STATUS_ERROR.value, description, BaseEnum.CODE_ERROR.value, null);
    }

    /**
     * 请求错误,设置错误说明和对应的状态码
     *
     * @param description 说明
     * @param code        状态码
     * @date 2019-06-05
     * @author cr
     */
    public static MyResult error(String description, String code) {
        return init(null, BaseEnum.STATUS_ERROR.value, description, code, null);
    }

    /**
     * 请求错误，设置说明，状态码, 对应的返回数据
     *
     * @param description 说明
     * @param code        状态码
     * @param data        返回的数据
     * @date 2019-06-05
     * @author cr
     */
    public static MyResult error(String description, String code, Object data) {
        return init(null, BaseEnum.STATUS_ERROR.value, description, code, data);
    }

    /**
     * 请求错误，记录地址
     *
     * @date 2019-06-05
     * @author cr
     */
    public static MyResult errorPath(String path) {
        return init(path, BaseEnum.STATUS_ERROR.value, BaseEnum.DESCRIPTION_ERROR.value, BaseEnum.CODE_ERROR.value, null);
    }

    /**
     * 请求错误，记录地址,设置错误说明
     *
     * @date 2019-06-05
     * @author cr
     */
    public static MyResult errorPath(String path, String description) {
        return init(path, BaseEnum.STATUS_ERROR.value, description, BaseEnum.CODE_ERROR.value, null);
    }

    /**
     * 请求错误,记录地址,设置错误说明和对应的状态码
     *
     * @param description 说明
     * @param code        状态码
     * @date 2019-06-05
     * @author cr
     */
    public static MyResult errorPath(String path, String description, String code) {
        return init(path, BaseEnum.STATUS_ERROR.value, description, code, null);
    }

    /**
     * 请求错误，设置说明，状态码, 对应的返回数据
     *
     * @param description 说明
     * @param code        状态码
     * @param data        返回的数据
     * @date 2019-06-05
     * @author cr
     */
    public static MyResult errorPath(String path, String description, String code, Object data) {
        return init(path, BaseEnum.STATUS_ERROR.value, description, code, data);
    }

    /**
     * 请求成功
     *
     * @date 2019-06-05
     * @author cr
     */
    public static MyResult success() {
        return init(null, BaseEnum.STATUS_SUCCESS.value, BaseEnum.DESCRIPTION_SUCCESS.value, BaseEnum.CODE_SUCCESS.value, null);
    }

    /**
     * 请求成功
     *
     * @param data 需要返回的数据
     * @date 2019-06-05
     * @author cr
     */
    public static MyResult success(Object data) {
        return init(null, BaseEnum.STATUS_SUCCESS.value, BaseEnum.DESCRIPTION_SUCCESS.value, BaseEnum.CODE_SUCCESS.value, data);
    }

    /**
     * 请求成功
     *
     * @param data        需要返回的数据
     * @param description 说明
     * @date 2019-06-05
     * @author cr
     */
    public static MyResult success(Object data, String description) {
        return init(null, BaseEnum.STATUS_SUCCESS.value, description, BaseEnum.CODE_SUCCESS.value, data);
    }

    /**
     * 请求成功
     *
     * @date 2019-06-05
     * @author cr
     */
    public static MyResult success(String path) {
        return init(path, BaseEnum.STATUS_SUCCESS.value, BaseEnum.DESCRIPTION_SUCCESS.value, BaseEnum.CODE_SUCCESS.value, null);
    }

    /**
     * 请求成功
     *
     * @param data 需要返回的数据
     * @date 2019-06-05
     * @author cr
     */
    public static MyResult success(String path, Object data) {
        return init(path, BaseEnum.STATUS_SUCCESS.value, BaseEnum.DESCRIPTION_SUCCESS.value, BaseEnum.CODE_SUCCESS.value, data);
    }

    /**
     * 请求成功
     *
     * @param data        需要返回的数据
     * @param description 说明
     * @date 2019-06-05
     * @author cr
     */
    public static MyResult success(String path, Object data, String description) {
        return init(path, BaseEnum.STATUS_SUCCESS.value, description, BaseEnum.CODE_SUCCESS.value, data);
    }
    // endregion

    // region 链式调法区

    public MyResult setPath(String path) {
        this.path = path;
        return this;
    }

    public MyResult setStatus(String status) {
        this.status = status;
        return this;
    }

    public MyResult setCode(String code) {
        this.code = code;
        return this;
    }

    public MyResult setDescription(String description) {
        this.description = description;
        return this;
    }

    public MyResult setData(Object data) {
        this.data = data;
        return this;
    }

    // endregion

    // region get方法区

    public String getServiceName() {
        return serviceName;
    }

    public String getPath() {
        return path;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Object getData() {
        return data;
    }

    // endregion

    private static MyResult init(String path, String status, String description, String code, Object data) {
        MyResult model = createInstance();
        model.path = path;
        model.status = status;
        model.description = description;
        model.code = code;
        model.data = data;
        return model;
    }

    // region 构造函数区


    /**
     * 基础的自定义返回,暂不确定是否使用
     *
     * @param path   请求的路由地址
     * @param status 状态
     * @param code   状态码
     * @date 2019-06-05
     * @author cr
     */
    private MyResult(String path, String status, String code) {
        this.path = path;
        this.status = status;
        this.code = code;
    }

    /**
     * 暂不确定是否使用
     */
    private MyResult(String path, String status, String code, String description, Object data) {
        this.path = path;
        this.status = status;
        this.code = code;
        this.description = description;
        this.data = data;

    }

    // endregion

    @Override
    public String toString() {
        return "CloudResultModel{" +
                "serviceName='" + serviceName + '\'' +
                ", path='" + path + '\'' +
                ", status='" + status + '\'' +
                ", code=" + code +
                ", description='" + description + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * 基础枚举
     *
     * @author cr
     * @date 2019-06-05
     */
    enum BaseEnum {
        // 状态
        STATUS_SUCCESS("SUCCESS"),
        STATUS_ERROR("ERROR"),
        // 说明
        DESCRIPTION_SUCCESS("请求成功"),
        DESCRIPTION_ERROR("请求失败"),
        // 状态代码
        CODE_SUCCESS("1000"),
        CODE_ERROR("1001");

        public String value;

        BaseEnum(String value) {
            this.value = value;
        }

    }

}