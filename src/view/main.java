package view;

public class main {
    public static void main(String[] args) {
        CRMJframe frame = new CRMJframe();

        LoginUI loginUI = new LoginUI();
        ManagerUI manager = new ManagerUI();
        CustomerUI customerUI = new CustomerUI();
        SubmitIssue submitIssue = new SubmitIssue();

        frame.add(loginUI);
        frame.add(manager);
        frame.add(customerUI);
        frame.add(submitIssue);
        frame.setVisible(true);
    }
}
