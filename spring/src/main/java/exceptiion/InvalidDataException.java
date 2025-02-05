package exceptiion;


public class InvalidDataException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public InvalidDataException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s with %s '%s' is invalid", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;

    }

    // Getters for the fields
    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
