package kz.seisen.ChainOfResponsibility.Logger;

public abstract class CustomLogger {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;

    protected int level;
    protected CustomLogger nextLogger;

    public CustomLogger(int level) {
        this.level = level;
    }

    public void setNextLogger(CustomLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void log(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.log(level, message);
        }
    }

    protected abstract void write(String message);
}