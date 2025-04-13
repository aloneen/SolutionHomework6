package kz.seisen.ChainOfResponsibility;

import kz.seisen.ChainOfResponsibility.Logger.CustomLogger;

class JuniorSupportHandler extends SupportHandler {
    @Override
    public boolean handle(String issue) {
        if (logger != null) {
            logger.log(CustomLogger.DEBUG, "[JuniorSupport] Received issue: " + issue);
        }
        if ("refund_request".equals(issue) || "billing_issue".equals(issue)) {
            System.out.println("[JuniorSupport] Handled " + issue);
            return true;
        }
        return next != null && next.handle(issue);
    }
}