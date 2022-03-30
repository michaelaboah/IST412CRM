import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import model.Customer;
import model.IssueTicket;
import model.IssueType;
import model.Manager;
import model.Manager.ManagerType;
import utility.ExternalDataControl;
import utility.JsonUtil;
import utility.MainData;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();

        Customer cus = new Customer();
        cus.setFirstName("customer firstname");
        cus.setLastName("customer lastName");
        cus.setUsername("customer username");
        cus.setPassword("customer password");
        cus.setCustID(31574986);
        MainData.getCustomers().add(cus);

        IssueTicket ticket = new IssueTicket();
        ticket.setName("ticketName");
        ticket.setDescription("ticketDescription");
        ticket.setReportID(8520562);
        ticket.setDateTime(LocalDateTime.now());
        ticket.setIsResolved(false);
        ticket.setCustOwner(new Customer("Joe", "Smith", "joesmith@gmail.com", "username", "password", "address", 133233));
        ticket.setRecipient(new Manager("Joe", "Dude", "m1", "12", ManagerType.CRM, 498654));
        ticket.setIssueType(IssueType.BILLING);
        ticket.setResponse("response");

        // MainData.getIssueTickets().add(ticket);
        
        // MainData.setIssueTickets();
            // JSONObject test = (JSONObject) JsonUtil.readJsonArray("IssueTicket.json").get(0);
            // System.out.println(test.get("Ticket Date"));

            // var clock = LocalDateTime.parse(test.get("Ticket Date").toString());
            // System.out.println(clock);
            
        // System.out.println(IssueTicket.jsonToIssueTicket(JsonUtil.readJsonArray("IssueTicket.json")).get(0).getDateTime());

        MainData.setIssueTickets(IssueTicket.jsonToIssueTicket(JsonUtil.readJsonArray("IssueTicket.json")));
        System.out.println(MainData.getIssueTickets().get(0).getCustOwner());
    }
}
