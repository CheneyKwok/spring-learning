package org.springframework.beans.factory.config;

/**
 * <p>
 * Bean 定义信息
 * <p>
 *
 * @author gzc
 * @since 2023-05-06
 */
public class BeanDefinition {

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    private Class<?> beanClass;

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }
}
