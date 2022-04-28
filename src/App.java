
import controller.ListCntl;
import model.Manager;
import model.SavedData;
import utility.MainData;
import view.*;


/**
 * Entry point for the CRM program
 * 
 * @param   args the command-line arguments for the program
 */
public class App {    
    public static void main(String[] args) throws Exception {

        SavedData.readAll("SaveMore.json");

        Testharness testharness = new Testharness();
        /*
        System.out.println(MainData.getManagers());
        
        CRMJframe frame = new CRMJframe();

        LoginUI loginUI = new LoginUI();
        CustomerUI customerUI = new CustomerUI();
        SubmitIssue submitIssue = new SubmitIssue();
        ManagerUI managerUI = new ManagerUI();
        ViewPreviousTickets previousTickets = new ViewPreviousTickets();

        ListCntl listCntl = new ListCntl(loginUI, customerUI, submitIssue, previousTickets, managerUI);
        listCntl.logInOut();
        listCntl.submitComplaint();
        listCntl.previousTickets();
        listCntl.manager();

        frame.add(loginUI);
        frame.add(managerUI);
        frame.add(customerUI);
        frame.add(submitIssue);
        frame.add(managerUI);
        frame.add(previousTickets);
        frame.setVisible(true);
        */
    }
}
