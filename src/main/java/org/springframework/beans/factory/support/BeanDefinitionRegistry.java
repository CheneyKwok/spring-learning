package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;

/**
 * <p>
 * BeanDefinition 注册器
 * <p>
 *
 * @author gzc
 * @since 2023-05-06
 */
public interface BeanDefinitionRegistry {

    void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
