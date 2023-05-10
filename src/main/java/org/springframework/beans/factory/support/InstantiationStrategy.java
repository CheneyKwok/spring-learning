package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;

/**
 * <p>
 * Bean 实例化策略
 * <p>
 *
 * @author gzc
 * @date 2023-05-10
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws Exception;
}
