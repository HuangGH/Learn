package com.greepark.ioc.beans;

import java.beans.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * @author hgh
 * @since 2020-01-30 12:23
 */
public class BeanInfosDemo {

    public static void main(String[] args) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        Stream.of(propertyDescriptors)
              .forEach(propertyDescriptor -> {
                  Person person = new Person();
                  if (propertyDescriptor.getName().equals("age")) {
                      propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditClass.class);
                      PropertyEditor propertyEditor = propertyDescriptor.createPropertyEditor(person);
                      propertyEditor.setAsText("23");
                      Method writeMethod = propertyDescriptor.getWriteMethod();
                      try {
                          writeMethod.invoke(person, 23);
                      } catch (IllegalAccessException e) {
                          e.printStackTrace();
                      } catch (InvocationTargetException e) {
                          e.printStackTrace();
                      }
                      propertyEditor.setAsText("33");
                      System.out.println(person);
                  }
              });


    }

    static class StringToIntegerPropertyEditClass2 extends PropertyEditorSupport {
        public StringToIntegerPropertyEditClass2() {
            super();
        }

        @Override
        public void setAsText(String text) {
            Integer integerValue = Integer.valueOf(text);
            this.setValue(integerValue);
        }
    }

}
