package Response;

public class PartialResponse {

        private String message;
        private String description;

        // Constructors, getters, and setters
        public PartialResponse(String message, String username) {
            this.message = message;
            this.description = username;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String username) {
            this.description = description;
        }
}
