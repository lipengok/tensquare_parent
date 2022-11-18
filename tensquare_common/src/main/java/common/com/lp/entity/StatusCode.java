package common.com.lp.entity;

/**
 * 统一状态码
 * @Author lipeng
 * @Date 2022/11/15 14:36
 * @Version 1.0
 */
public class StatusCode {
    public static final int OK=20000;//成功
    public static final int ERROR =20001;//失败
    public static final int LOGINERROR =20002;//用户名或密码错误
    public static final int ACCESSERROR =20003;//权限不足
    public static final int REMOTEERROR =20004;//远程调用失败
    public static final int REPERROR =20005;//重复操作
}
