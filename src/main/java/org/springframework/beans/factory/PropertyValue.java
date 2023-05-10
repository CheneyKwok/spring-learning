package org.springframework.beans.factory;

/**
 * <p>
 * bean 的属性值
 * <p>
 *
 * @author gzc
 * @date 2023-05-10
 */
public class PropertyValue {

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    private String name;

    private Object value;

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}