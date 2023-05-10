package org.springframework.beans.factory.support;

import org.springframework.beans.factory.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 具有自动装配能力的抽象 bean 工厂
 * <p>
 *
 * @author gzc
 * @since 2023-05-06
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    @Override
    public Object createBean(String beanName, BeanDefinition definition) {
        return doCreatBean(beanName, definition);
    }

    protected Object doCreatBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = getInstantiationStrategy().instantiate(beanDefinition);
        } catch (Exception e) {
            throw new RuntimeException("Instantiation bean failed", e);
        }
        populateBean(bean, beanDefinition);

        addSingletonObject(beanName, bean);
        return bean;
    }

    private void populateBean(Object bean, BeanDefinition beanDefinition) {
            List<Field> fields = getFields(bean);

            for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                Field field = fields.stream()
                        .filter(e -> e.getName().equals(name)).findFirst()
                        .orElseThrow(() -> new RuntimeException("no such field: " + name));

                field.setAccessible(true);
                try {
                    field.set(bean, value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("populate bean failed, bean: " +
                            bean.getClass() + " property: " + name + " value: " + value, e);
                }

            }
    }

    private List<Field> getFields(Object bean) {
        Class<?> targetClazz = bean.getClass();
        List<Field> fields = new ArrayList<>();
        while (targetClazz != null) {
            Field[] declaredFields = targetClazz.getDeclaredFields();
            fields.addAll(Arrays.stream(declaredFields).collect(Collectors.toList()));
            targetClazz = targetClazz.getSuperclass();
        }
        return fields;
    }
}
