package UI;

public class Communicate {

    private final String message;

    public Communicate(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println(message);
    }
}
