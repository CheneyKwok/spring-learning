package org.springframework.test.ioc;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.PropertyValue;
import org.springframework.beans.factory.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.ioc.bean.Person;

/**
 * <p>
 * 填充 bean 属性测试类
 * <p>
 *
 * @author gzc
 * @date 2023-05-10
 */
public class PopulateBeanWithPropertyValuesTest {

    @Test
    public void testPopulateBeanWithPropertyValues() {
        String name = "Tom";
        int age = 18;
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", name));
        propertyValues.addPropertyValue(new PropertyValue("age", age));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValues);
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registryBeanDefinition("person", beanDefinition);
        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person.getName());
        System.out.println(person.getAge());
        Assertions.assertThat(person.getName()).isEqualTo(name);
        Assertions.assertThat(person.getAge()).isEqualTo(age);

    }
}
