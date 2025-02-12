package com.github.lucasmartins.task_lister.domain.model.abstractions;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

public class AbstractService<E extends AbstractEntity, D extends AbstractDomain> {

    private final Class<D> domainClass;

    public AbstractService() {
        Type[] actualTypeArguments = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
        this.domainClass = (Class<D>) actualTypeArguments[0];
    }


    public D convertToDomain(E entity) {
        try {
            final D target = domainClass.getDeclaredConstructor().newInstance();
            final Field[] sourceFields = entity.getClass().getDeclaredFields();
            final Field[] targetFields = domainClass.getDeclaredFields();

            for (Field sourceField : sourceFields) {
                sourceField.setAccessible(true);

                for (Field targetField : targetFields) {
                    targetField.setAccessible(true);

                    if (Objects.equals(sourceField.getName(), targetField.getName()) && Objects.equals(sourceField.getType(), targetField.getType())) {
                        targetField.set(target, sourceField.get(entity));
                    }
                }
            }
            return target;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping objects", e);
        }
    }
}
