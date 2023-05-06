package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 单例 bean 注册器默认实现
 * <p>
 *
 * @author gzc
 * @since 2023-05-06
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String, Object> singletonObjects = new HashMap<>();
    @Override
    public Object getSingletonObject(String name) {
        return singletonObjects.get(name);
    }


    public void addSingletonObject(String name, Object singletonObject) {
        singletonObjects.put(name, singletonObject);
    }

}
