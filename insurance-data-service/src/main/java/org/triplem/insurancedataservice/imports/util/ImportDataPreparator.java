package org.triplem.insurancedataservice.imports.util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.triplem.insurancedataservice.util.exception.FileFieldMappingException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Slf4j
public class ImportDataPreparator<C> {

    private DateFormatter dateFormatter;
    private NumberFormatter numberFormatter;

    private Map<String, Field> getFieldsToColumnNames(Collection<String> attributes, Class<C> dataClass) {

        ColumnExtracter<?> columnExtracter = new ColumnExtracter<>(dataClass);

        Map<String, Field> attributesToFields =
                attributes.stream()
                        .filter(attribute -> columnExtracter.getColumnField(attribute) != null)
                        .collect(Collectors.toMap(Function.identity(), columnExtracter::getColumnField));

        if(attributesToFields.size() < columnExtracter.getFieldsSize()) {
            throw new FileFieldMappingException("Attributes from import file do not match database attributes");
        }

        return attributesToFields;
    }

    private Map<String, Method> getSettersToAttributes(Collection<Field> fields, Class<C> databaseClass) {

        Map<String, Method> attributeToSetter = new HashMap<>();

        fields.forEach(field -> {
                    Method setter = getSetterOfField(databaseClass, field);
                    if(setter != null)
                        attributeToSetter.put(field.getName(), setter);
                });

        return attributeToSetter;
    }

    private Method getSetterOfField(Class<C> databaseClass, Field field) {
       return Arrays.stream(databaseClass.getMethods())
                .filter(method -> method.getName().startsWith("set"))
                .filter(method -> method.getName().toUpperCase(Locale.ROOT).equals(("set" + field.getName()).toUpperCase(Locale.ROOT)))
                .findFirst().orElse(null);
    }

    public List<C> getInsertData(Class<C> dataClass, List<C> insertData, Map<String, List<String>> valuesPerAttribute) {

        Map<String, Field> attributesToFields = getFieldsToColumnNames(valuesPerAttribute.keySet(), dataClass);
        Map<String, Method> attributesToSetters = getSettersToAttributes(attributesToFields.values(), dataClass);

        Map<String, List<String>> filteredValuesPerAttribute = valuesPerAttribute.entrySet().stream()
                .filter(attributesEntry -> attributesToFields.containsKey(attributesEntry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if(attributesToFields.size() != filteredValuesPerAttribute.size())
            throw new FileFieldMappingException("Filtered values per attribute did not match the fields of the database");

        filteredValuesPerAttribute.forEach((attribute, values) -> {
            Method setter = attributesToSetters.get(attributesToFields.get(attribute).getName());
            int indexForLogging = 0;
            try {
                for (int index = 0; index < values.size(); index++) {
                    indexForLogging = index;
                    Object castObject = getCastObjectToField(values.get(index), attributesToFields.get(attribute));
                    Object importObject = insertData.get(index);
                    log.debug("Setter: {} castObject: {} importObject: {}", setter.getName(), castObject, importObject);
                    ReflectionUtils.invokeMethod(setter, importObject, castObject);
                }
            } catch(IllegalArgumentException ex) {
                
                String value;
                if(indexForLogging < values.size())
                    value = values.get(indexForLogging);
                else
                    value = "null (empty or null string/value)";

                log.error("Could not set value: {} for attribute: {} with field type: {}", value, attribute, attributesToFields.get(attribute));
                throw new RuntimeException(ex.getMessage());
            }
        });

        return insertData;
    }

    private Object getCastObjectToField(String value, Field field) {
        if(field.getType().equals(Date.class))
            return dateFormatter.formatDate(value);
        else if(field.getType().getGenericSuperclass().equals(Number.class))
            return numberFormatter.getNumberOfString(value, field);
        else
            return value;
    }

}
