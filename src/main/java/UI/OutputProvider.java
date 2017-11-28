package UI;


public class OutputProvider {

    private MyScanner scanner;

    public OutputProvider(MyScanner scanner){
        this.scanner = scanner;
    }

    public Output askForOutputType() {
        System.out.println("Press 0 for standard output, 1 for err type output");
        Output output = new SystemPrintOut();
        try {
            int symbol = Integer.valueOf(scanner.nextLine());
            switch (symbol){
                case 0:
                    output = new SystemPrintOut();
                    break;
                case 1:
                    output = new SystemErrOut();
                    break;
                default:
                    output = new SystemPrintOut();
                    break;
            }
        } catch (Exception e){
            output.display("invalid number");
        }
        return output;
    }


}
