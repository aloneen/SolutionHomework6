package kz.seisen.ChainOfResponsibility;

import kz.seisen.ChainOfResponsibility.Logger.ConsoleCustomLogger;
import kz.seisen.ChainOfResponsibility.Logger.CustomLogger;
import kz.seisen.ChainOfResponsibility.Logger.ErrorCustomLogger;
import kz.seisen.ChainOfResponsibility.Logger.FileCustomLogger;

public class ChainMain {
    public static void main(String[] args) {
        // Setup the custom logger chain ---
        // Create loggers with different levels.
        CustomLogger errorLogger = new ErrorCustomLogger(CustomLogger.ERROR);
        CustomLogger fileLogger = new FileCustomLogger(CustomLogger.DEBUG);
        CustomLogger consoleLogger = new ConsoleCustomLogger(CustomLogger.INFO);

        // Link the loggers together.
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        // Set the global logger used by all support handlers.
        SupportHandler.setLogger(errorLogger);

        // --- Build the support chain ---
        SupportHandler faq = new FAQBotHandler();
        SupportHandler junior = new JuniorSupportHandler();
        SupportHandler senior = new SeniorSupportHandler();
        faq.setNext(junior).setNext(senior);

        // --- Test the chain with various issues ---
        String[] issues = {"password_reset", "refund_request", "account_ban", "unknown_bug"};

        for (String issue : issues) {
            try {
                faq.handle(issue);
            } catch (UnresolvedIssueException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }
        }
    }
}