package org.springframework.beans.factory.config;

/**
 * <p>
 * 单例 bean 注册器
 * <p>
 *
 * @author gzc
 * @since 2023-05-06
 */
public interface SingletonBeanRegistry {

    Object getSingletonObject(String name);
}
