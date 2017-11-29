package ui;

public class SystemErrOut implements Output{
    @Override
    public void display(String msg) {
        System.err.println(msg);
    }
}
