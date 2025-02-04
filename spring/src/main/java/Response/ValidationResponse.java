package Response;

public class ValidationResponse {
    int code;
    String message;
    String desciption;

    public ValidationResponse(int code, String message, String desciption) {
        this.code = code;
        this.message = message;
        this.desciption = desciption;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
}
