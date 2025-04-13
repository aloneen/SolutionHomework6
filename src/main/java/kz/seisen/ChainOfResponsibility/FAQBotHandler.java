package kz.seisen.ChainOfResponsibility;

class FAQBotHandler extends SupportHandler {
    public boolean handle(String issue) {
        if (issue.equals("password_reset")) {
            System.out.println("[FAQBot] Handled " + issue);
            return true;
        }
        return next != null && next.handle(issue);
    }
}