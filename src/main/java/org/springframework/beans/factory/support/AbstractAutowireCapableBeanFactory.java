package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;

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
        addSingletonObject(beanName, bean);
        return bean;
    }
}
