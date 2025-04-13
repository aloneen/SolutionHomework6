package kz.seisen.ChainOfResponsibility;

class SeniorSupportHandler extends SupportHandler {
    public boolean handle(String issue) {
        if (issue.equals("account_ban") || issue.equals("data_loss")) {
            System.out.println("[SeniorSupport] Handled " + issue);
            return true;
        }
        System.out.println("[SeniorSupport] Cannot handle " + issue + " — escalate manually");
        return false;
    }
}