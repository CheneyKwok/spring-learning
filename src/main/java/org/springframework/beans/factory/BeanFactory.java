package org.springframework.beans.factory;

/**
 * <p>
 * Bean 工厂
 * <p>
 *
 * @author gzc
 * @since 2023-05-06
 */
public interface BeanFactory {

    Object getBean(String name);
}
