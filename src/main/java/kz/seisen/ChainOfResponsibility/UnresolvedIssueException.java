package kz.seisen.ChainOfResponsibility;

public class UnresolvedIssueException extends RuntimeException {
    public UnresolvedIssueException(String message) {
        super(message);
    }
}
