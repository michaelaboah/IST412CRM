package view;

public class main {
    public static void main(String[] args) {
        CRMJframe frame = new CRMJframe();

        LoginUI loginUI = new LoginUI();
        ManagerUI manager = new ManagerUI();

        frame.add(loginUI);
        frame.add(manager);
        frame.setVisible(true);
    }
}
