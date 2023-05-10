package org.springframework.beans.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * bean 属性持有者
 * <p>
 *
 * @author gzc
 * @date 2023-05-10
 */
public class PropertyValues {
    private List<PropertyValue> propertyValueList = new ArrayList<>();


    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[]{});
    }

    public void addPropertyValue(PropertyValue propertyValue ) {
        this.propertyValueList.add(propertyValue);
    }

    public PropertyValue getPropertyValue(String name) {
       return propertyValueList
               .stream()
               .filter(e -> e.getName().equals(name))
               .findFirst()
               .orElseThrow(() -> new RuntimeException("not exist pv: " + name));
    }
}
