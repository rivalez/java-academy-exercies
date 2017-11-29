package ui;

public class SystemPrintOut implements Output {
    @Override
    public void display(String msg) {
        System.out.println(msg);
    }
}
