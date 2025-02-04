package exceptiion;

import java.time.LocalDateTime;

public class ErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private String details;
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    // Constructor
    public ErrorDetails(LocalDateTime timestamp, String message, String details,
                        String resourceName, String fieldName, Object fieldValue) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    // Getters and Setters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

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

