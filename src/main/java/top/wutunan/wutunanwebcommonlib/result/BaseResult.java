package top.wutunan.wutunanwebcommonlib.result;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * mvc框架的响应结果对象
 * <p> BaseResult类型<T> </p>
 * T表示: 要返回的泛型对象，名字叫data的属性,开发人员手动指定指定泛型类型。
 *
 * @author wutunan
 * @Date 2024/6/5
 * @since JDK1.8
 */
public class BaseResult<T> {

    /**
     * 响应状态码
     */
    private int code = 0;

    /**
     * 响应成功的消息。默认是ok
     */
    private String msg = "ok";
    /**
     * 返回的数据对象。泛型T指定。
     */
    private T data;

    /**
     * BaseResult空参构造
     */
    public BaseResult() {
    }

    /**
     * 初始化，BaseResult对象的数据泛型对象。
     * 泛型的类型由:开发人员手动的指定。
     * <p>example:<p/>
     * <pre>
     *      // 开发人员 指定泛型为：Integer
     *      BaseResult<Integer> baseResult = new BaseResult<>();
     *      // 开发人员 指定泛型为：Object
     *      BaseResult<Object> baseResult = new BaseResult<>();
     * </pre>
     *
     * @param data
     */
    public BaseResult(T data) {
        this.data = data;
    }

    /**
     * 使用枚举对象进行指定：用户可以自定义。
     * <pre>
     *     int code = ApiEnum.DATA_ADD_FAILED.getCode()
     * </pre>
     *
     * @param iRespEnum 在同一个包下，可以找到IRespEnum接口。
     * @see IRespEnum  top.wutunan.wutunanwebcommonlib.result.IRespEnum
     */
    public BaseResult(IRespEnum iRespEnum) {
        this.code = iRespEnum.getCode();
        this.msg = iRespEnum.getMsg();
    }

    /**
     * @param code 响应码
     * @param msg  响应消息
     */
    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 全参数构造方法
     * @param code   响应码
     * @param msg    响应消息
     * @param object
     */
    public BaseResult(int code, String msg, T object) {
        this.code = code;
        this.msg = msg;
        this.data = object;
    }

    /**
     * 设置响应状态的方法
     * <pre>
     *     BaseResult<Integer> baseResult = new BaseResult<>();
     *     // IRespEnum 的子类对象；
     *     top.wutunan.web.controller.result.ApiEnum.DATA_ADD_FAILED
     *     baseResult.setStatus()
     * </pre>
     *
     * @param iRespEnum 结果集枚举对象
     * @see IRespEnum top.wutunan.wutunanwebcommonlib.result.IRespEnum
     */
    public void setStatus(IRespEnum iRespEnum) {
        this.code = iRespEnum.getCode();
        this.msg = iRespEnum.getMsg();
    }


    /**
     * 设置响应状态的方法
     * @param code 响应状态码
     * @param msg  响应消息码
     */
    public void setStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 默认设置是成功的 0;
     * @return 默认情况下Jackson库会将isOk()和isSuccess()方法Jackson会认为它们对应ok和success属性。@JsonIgnore忽略不要进行序列化返回给前端。
     */
    @JsonIgnore
    public boolean isOk() {
        return this.code == 0;
    }

    /**
     * 默认设置是成功的 0;
     * @return
     */
    @JsonIgnore
    public boolean isSuccess() {
        return this.code == 0;
    }

    /**
     * get方法当前对象的状态方法。
     * @return 当前对象的响应状态
     */
    public int getCode() {
        return this.code;
    }


    /**
     * @return 当前对象的响应消息
     */
    public String getMsg() {
        return this.msg;
    }

    /**
     * @return 获取当前对象的数据属性
     */
    public T getData() {
        return this.data;
    }


    /**
     * @param code 设置响应状态码
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @param msg 设置响应的消息
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @param data 设置响应的数据
     */
    public void setData(T data) {
        this.data = data;
    }

}
