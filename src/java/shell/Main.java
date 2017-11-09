package shell;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyShell myShell = (MyShell) context.getBean("myShell");
        myShell.loop();
    }
}
