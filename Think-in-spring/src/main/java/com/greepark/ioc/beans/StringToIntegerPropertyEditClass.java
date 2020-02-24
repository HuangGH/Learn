package com.greepark.ioc.beans;

import java.beans.PropertyEditorSupport;

/**
 * @author hgh
 * @since 2020-01-30 13:55
 */
public class StringToIntegerPropertyEditClass extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        Integer integerValue = Integer.valueOf(text);
        setValue(integerValue);
    }
}
