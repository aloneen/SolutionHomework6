package kz.seisen.ChainOfResponsibility.Logger;

public class FileCustomLogger extends CustomLogger {
    public FileCustomLogger(int level) {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("File Logger: " + message);
    }
}
