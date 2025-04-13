package kz.seisen.ChainOfResponsibility;

import kz.seisen.ChainOfResponsibility.Logger.CustomLogger;

class SeniorSupportHandler extends SupportHandler {
    @Override
    public boolean handle(String issue) {
        if (logger != null) {
            logger.log(CustomLogger.DEBUG, "[SeniorSupport] Received issue: " + issue);
        }
        if ("account_ban".equals(issue) || "data_loss".equals(issue)) {
            System.out.println("[SeniorSupport] Handled " + issue);
            return true;
        }
        String msg = "[SeniorSupport] Cannot handle " + issue + " — escalate manually";
        System.out.println(msg);
        throw new UnresolvedIssueException(msg);
    }
}
