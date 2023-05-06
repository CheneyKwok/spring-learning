package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.service.HelloService;

/**
 * <p>
 * BeanDefinition 及 BeanDefinitionRegistry 测试类
 * <p>
 *
 * @author gzc
 * @since 2023-05-06
 */
public class BeanDefinitionAndBeanDefinitionRegistryTest {

    @Test
    public void testBeanFactory() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registryBeanDefinition("helloService", new BeanDefinition(HelloService.class));
        HelloService helloService = (HelloService) factory.getBean("helloService");
        helloService.sayHello();
    }
}
