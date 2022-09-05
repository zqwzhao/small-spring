package top.zhaoqw.springframework.factory;

/**
 * @author zhaoqw
 * @date 2022/08/31
 */
public class BeansException extends Exception{
  public BeansException(String message, Throwable cause) {
    super(message, cause);
  }

  public BeansException(String message) {
    super(message);
  }
}
