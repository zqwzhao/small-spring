package top.zhaoqw.springframework.factory.beans.factory.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import top.zhaoqw.springframework.factory.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author zhaoqw
 * @date 2022/09/05
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
  @Override
  public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(beanDefinition.getBeanClass());
    enhancer.setCallback(new NoOp() {
      @Override
      public int hashCode() {
        return super.hashCode();
      }
    });
    if (null == constructor) {
      return enhancer.create();
    }

    return enhancer.create(constructor.getParameterTypes(), args);
  }
}
