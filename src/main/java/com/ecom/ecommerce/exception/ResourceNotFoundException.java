package com.ecom.ecommerce.exception;

public class ResourceNotFoundException extends RuntimeException {
    String ResourceName;
    String Field;
    String FieldName;
    Long FieldId;

    public ResourceNotFoundException(){
    }

    public ResourceNotFoundException(String resourceName, String field, String fieldName) {
        super(String.format("%s not found with %s: %s", resourceName, field, fieldName));
        ResourceName = resourceName;
        Field = field;
        FieldName = fieldName;
    }

    public ResourceNotFoundException(String resourceName, String field, Long fieldId) {
        super(String.format("%s not found with %s: %d", resourceName, field, fieldId));
        ResourceName = resourceName;
        Field = field;
        FieldId = fieldId;
    }
}
