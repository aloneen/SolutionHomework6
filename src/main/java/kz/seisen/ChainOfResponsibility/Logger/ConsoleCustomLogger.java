package kz.seisen.ChainOfResponsibility.Logger;

public class ConsoleCustomLogger extends CustomLogger {
    public ConsoleCustomLogger(int level) {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("Console Logger: " + message);
    }
}