package top.wutunan.wutunanwebcommonlib.result;

/**
 * 枚举消息对象的接口,枚举类实现IRespEnum。
 * <p>example: </p>
 * <pre>
 *  public enum ApiEnum implements IRespEnum {
 *      // 对象成员属性
 *     private int code;
 *     private String msg;
 *     // 创建对象的成员方法
 *     ApiEnum(int code, String msg) {
 *         this.code = code;
 *         this.msg = msg;
 *     }
 *     // 实现接口的抽象方法
 *     public int getCode() {
 *         return code;
 *     }
 *     // 实现接口的抽象方法
 *     public String getMsg() {
 *         return msg;
 *     }
 * }
 * </pre>
 * <p>这个样做的目的时：为了可以自己定义：Api的msg。</p>
 * @author  wutunan
 * @since JDK1.8
 * @Date 2024/6/5
 */
public interface IRespEnum {


    /**
     *
     * @return 获取一个状态码
     */
    int getCode();

    /**
     * @return 响应消息描述信息
     */
    String getMsg();
}
