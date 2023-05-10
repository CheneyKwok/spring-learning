package org.springframework.beans.factory.config;

import org.springframework.beans.factory.PropertyValues;

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
        this(beanClass, null);
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    private Class<?> beanClass;

    private PropertyValues propertyValues;


    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }
}
