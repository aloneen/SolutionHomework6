package kz.seisen.ChainOfResponsibility.Logger;

public class ErrorCustomLogger extends CustomLogger {
    public ErrorCustomLogger(int level) {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Logger: " + message);
    }
}

