package org.springframework.test.service;

/**
 *
 * @author gzc
 * @since 2023-05-06
 */
public class HelloService {

    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }
}
