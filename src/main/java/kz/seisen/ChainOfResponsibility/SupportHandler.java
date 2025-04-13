package kz.seisen.ChainOfResponsibility;


import kz.seisen.ChainOfResponsibility.Logger.CustomLogger;

abstract class SupportHandler {
    protected SupportHandler next;

    protected static CustomLogger logger;


    public static void setLogger(CustomLogger logger) {
        SupportHandler.logger = logger;
    }

    public SupportHandler setNext(SupportHandler next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(String issue);
}
