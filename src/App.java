
import controller.ListCntl;
import model.SavedData;
import view.*;


/**
 * Entry point for the CRM program
 * 
 * @param   args the command-line arguments for the program
 */
public class App {    
    public static void main(String[] args) {

        SavedData.readAll("SaveMore.json");
        
        
        CRMJframe frame = new CRMJframe();

        LoginUI loginUI = new LoginUI();
        CustomerUI customerUI = new CustomerUI();
        SubmitIssue submitIssue = new SubmitIssue();
        ManagerUI managerUI = new ManagerUI();
        ViewPreviousTickets previousTickets = new ViewPreviousTickets();

        ListCntl listCntl = new ListCntl(loginUI, customerUI, submitIssue, previousTickets);
        listCntl.customers();
        listCntl.submitComplaint();
        listCntl.previousTickets();

        frame.add(loginUI);
        frame.add(managerUI);
        frame.add(customerUI);
        frame.add(submitIssue);
        frame.add(managerUI);
        frame.add(previousTickets);
        frame.setVisible(true);

    }
}
