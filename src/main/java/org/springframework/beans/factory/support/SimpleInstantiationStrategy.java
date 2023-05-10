package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * <p>
 * 简单 bean 实例化实现
 * <p>
 *
 * @author gzc
 * @date 2023-05-10
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws Exception {
        Class<?> beanClass = beanDefinition.getBeanClass();
        try {
            Constructor<?> constructor = beanClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("Failed to instantiate bean: " + beanClass.getName());
        }
    }
}
