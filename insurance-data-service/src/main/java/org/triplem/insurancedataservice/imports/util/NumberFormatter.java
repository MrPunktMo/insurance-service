package org.triplem.insurancedataservice.imports.util;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.math.BigDecimal;

@Component
public class NumberFormatter {

    public Object getNumberOfString(String value, Field field) {
        Object castNumber = null;
        if(field.getType().getGenericSuperclass().equals(Number.class)) {
            castNumber = getCastNumber(value, field);
        }
        return castNumber;
    }

    private Object getCastNumber(String value, Field field) {
        Object castNumber;

        if(field.getType().equals(Integer.class)) {
            castNumber = Integer.parseInt(value);
        } else if(field.getType().equals(Long.class)) {
            castNumber = Long.parseLong(value);
        } else if(field.getType().equals(Double.class)) {
            castNumber = Double.parseDouble(value.replace(",", "."));
        } else {
            value = value.replace(",", ".");
            if(value.contains("."))
                castNumber = BigDecimal.valueOf(Double.parseDouble(value));
            else
                castNumber = BigDecimal.valueOf(Long.parseLong(value));
        }

        return castNumber;
    }

}
