package kz.seisen.ChainOfResponsibility;

class JuniorSupportHandler extends SupportHandler {
    public boolean handle(String issue) {
        if (issue.equals("refund_request") || issue.equals("billing_issue")) {
            System.out.println("[JuniorSupport] Handled " + issue);
            return true;
        }
        return next != null && next.handle(issue);
    }
}
