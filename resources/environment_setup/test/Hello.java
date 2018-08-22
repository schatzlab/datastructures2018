// Hello.java - Test hello world program.


/** Hello class. */
public class Hello {
    private String message;

    /** Constructor (for testing purposes). */
    public Hello() {
        this.message = "Hello, World!";
    }

    /**
     * Gets the hello world message.
     * @return The hello world message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Main program.
     * @param args The command line arguments (none).
     */
    public static void main(String[] args) {
        Hello hello = new Hello();
        System.out.println(hello.getMessage());
    }
}
