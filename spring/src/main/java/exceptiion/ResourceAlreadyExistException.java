package exceptiion;

public class ResourceAlreadyExistException extends RuntimeException {
    // Custom Exception
        public ResourceAlreadyExistException(String message) {
            super(message);
        }
}
