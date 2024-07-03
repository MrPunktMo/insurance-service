package org.triplem.insurancedataservice.imports.util;

import jakarta.persistence.Column;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ColumnExtracter<T> {

    private final Map<String, Field> fieldsByColumn;

    public ColumnExtracter(Class<T> databaseClass) {

        this.fieldsByColumn = Stream.of(databaseClass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .collect(Collectors.toMap(field -> field.getAnnotation(Column.class).name().toUpperCase(Locale.ROOT), Function.identity()));
    }

    public Field getColumnField(String attribute) {
        return fieldsByColumn.get(attribute.toUpperCase(Locale.ROOT));
    }

    public int getFieldsSize() {
        return this.fieldsByColumn.size();
    }

}
