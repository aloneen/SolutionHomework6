package kz.seisen.ChainOfResponsibility;

import kz.seisen.ChainOfResponsibility.Logger.CustomLogger;

class FAQBotHandler extends SupportHandler {
    @Override
    public boolean handle(String issue) {
        if (logger != null) {
            logger.log(CustomLogger.DEBUG, "[FAQBot] Received issue: " + issue);
        }
        if ("password_reset".equals(issue)) {
            System.out.println("[FAQBot] Handled " + issue);
            return true;
        }
        return next != null && next.handle(issue);
    }
}