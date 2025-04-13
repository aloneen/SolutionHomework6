package kz.seisen.ChainOfResponsibility;

abstract class SupportHandler {
    protected SupportHandler next;

    public SupportHandler setNext(SupportHandler next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(String issue);
}
