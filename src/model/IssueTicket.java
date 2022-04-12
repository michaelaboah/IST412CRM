
package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

// import controller.ListCntl;


public class IssueTicket implements Serializable {

    

    private String name, description;
    private Integer reportID;
    private LocalDateTime dateTime;
    private Boolean isResolved;
    private Customer custOwner;
    private Manager recipient;
    private IssueType issueType;
    private String response;
    private static int issueTicketsCreated;
    private static ArrayList<IssueTicket> issueTicketList;

    public IssueTicket(String name, String description, Integer reportID, LocalDateTime dateTime, Boolean isResolved,
            Customer custOwner, Manager recipient, IssueType issueType, String response) {
        this.name = name;
        this.description = description;
        this.reportID = reportID;
        this.dateTime = dateTime;
        this.isResolved = isResolved;
        this.custOwner = custOwner;
        this.recipient = recipient;
        this.issueType = issueType;
        this.response = response;
    }

    public IssueTicket(String description, Integer reportID, LocalDateTime dateTime, Boolean isResolved, String type){
        this.description = description;
        this.reportID = reportID;
        this.dateTime = dateTime;
        this.isResolved = isResolved;
        
        switch (type) {
            case "-":
            this.issueType = IssueType.None;
            break;
    
            case "A current shipment progress":
            this.issueType = IssueType.SHIPMENT;
            break;

            case "Billing":
            this.issueType = IssueType.BILLING;
            break;

            case "A product I ordered":
            this.issueType = IssueType.PRODUCT;
            break;

            case "Website":
            this.issueType = IssueType.TECH_SUPPORT;
            break;
            
            case "Other":
            this.issueType = IssueType.OTHER;
            break;

            default:
                break;
        }
    }

    public IssueTicket(IssueTicketBuilder builder) {

        this.reportID = builder.reportID;
        this.dateTime = builder.dateTime;
        this.name = builder.name;
        this.isResolved = builder.isResolved;
        this.description = builder.description;
        this.custOwner = builder.custOwner;
        this.recipient = builder.recipient;
        this.issueType = builder.issueType;

        try {
            issueTicketList.add(this);
        }
        catch(NullPointerException e) {
            issueTicketList = new ArrayList<>();
            issueTicketList.add(this);
        }

        
    }

    public IssueTicket() {

        // this.reportID = 1234;
        // this.dateTime = LocalDateTime.of(2017, 1, 14, 10, 34);
        // this.name = "name";
        // this.custOwner = new Customer();
        // this.isResolved = false;
        // this.description = "description";
        // this.recipient = new Manager();
        // this.issueType = IssueType.PRODUCT;
        // this.response = "Awaiting response from representative,";
        // try {
        //     issueTicketList.add(this);
        // }
        // catch(NullPointerException e) {
        //     issueTicketList = new ArrayList<>();
        //     issueTicketList.add(this);
        // }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReportID() {
        return reportID;
    }

    public void setReportID(Integer reportID) {
        this.reportID = reportID;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Boolean getIsResolved() {
        return isResolved;
    }

    public void setIsResolved(Boolean isResolved) {
        this.isResolved = isResolved;
    }

    public Customer getCustOwner() {
        return custOwner;
    }

    public void setCustOwner(Customer custOwner) {
        this.custOwner = custOwner;
    }

    public Manager getRecipient() {
        return recipient;
    }

    public void setRecipient(Manager recipient) {
        this.recipient = recipient;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public static int getIssueTicketsCreated() {
        return issueTicketsCreated;
    }

    public static void setIssueTicketsCreated(int issueTicketsCreated) {
        IssueTicket.issueTicketsCreated = issueTicketsCreated;
    }

    public static ArrayList<IssueTicket> getIssueTicketList() {
        return issueTicketList;
    }

    public static void setIssueTicketList(ArrayList<IssueTicket> issueTicketList) {
        IssueTicket.issueTicketList = issueTicketList;
    }

    // public static void printTicketList() {
    //     String listStr = "Issue Ticket List: \n";
    //     for (int i = 0; issueTicketList.size(); i++) {
    //         listStr += issueTicketList.get(i).getName() + "\n";
    //     }
    //     System.out.println(listStr);
    // }

    // public static JSONObject issueTicketToJson(IssueTicket issueTicket){
    //     var jObject = new JSONObject();
    //     jObject.put("Ticket Name", issueTicket.name);
    //     jObject.put("Ticket Description", issueTicket.description);
    //     jObject.put("Ticket ReportID", issueTicket.reportID);
    //     jObject.put("Ticket Date", issueTicket.dateTime.toString());
    //     jObject.put("Ticket Customer", Customer.customerToJson(issueTicket.custOwner));
    //     jObject.put("Ticket Recipient", Manager.managerToJson(issueTicket.recipient));
    //     jObject.put("Ticket IssueType", issueTicket.issueType.toString());
    //     jObject.put("Ticket Response", issueTicket.response);
    //     jObject.put("Number Created", issueTicket.issueTicketsCreated);
    //     jObject.put("Ticket List", issueTicket.issueTicketList);
    //     return jObject;
    // }

    // public static JSONArray issueTicketJsonArray(ArrayList<IssueTicket> testArr){
    //     var jsonArray = new JSONArray();
    //     for (IssueTicket element : testArr) {
    //         jsonArray.add(issueTicketToJson(element));
    //     }
    // return jsonArray;
    // }



    // public static ArrayList<IssueTicket> jsonToIssueTicket(JSONArray jArray){
    //     var list = new ArrayList<IssueTicket>();
    //     var ticket = new IssueTicket();
    //     for (int i = 0; i < jArray.size(); i++) {
    //         JSONObject jObject = (JSONObject) jArray.get(i);
    //         ticket.setName(jObject.get("Ticket Name").toString());
    //         ticket.setDescription(jObject.get("Ticket Description").toString());
    //         ticket.setDateTime(LocalDateTime.parse(jObject.get("Ticket Date").toString()));
    //         ticket.setResponse(jObject.get("Ticket Response").toString());
    //         ticket.setRecipient(Manager.jsonToManager((JSONObject)jObject.get("Ticket Recipient")));    
    //         ticket.setReportID(Integer.parseInt(jObject.get("Ticket ReportID").toString()));
    //         ticket.issueTicketsCreated = Integer.parseInt(jObject.get("Number Created").toString());
    //         ticket.setCustOwner(Customer.jsonToCustomer((JSONObject)jObject.get("Ticket Customer")));
    //         list.add(ticket);
    //     }
    //     return list;
    // }

    @Override
    public String toString() {
        return "IssueTicket [custOwner=" + custOwner + ", dateTime=" + dateTime + ", description=" + description
                + ", isResolved=" + isResolved + ", issueType=" + issueType + ", name=" + name + ", recipient="
                + recipient + ", reportID=" + reportID + ", response=" + response + "]";
    }


    public String getExtra() {

        return "extra";
    }

    public static class IssueTicketBuilder
	{
		private String name, description;
        private Integer reportID;
        private LocalDateTime dateTime;
        private Boolean isResolved;
        private Customer custOwner;
        private Manager recipient;
        private IssueType issueType;
        private String response;
        private static int issueTicketsCreated;

		public IssueTicketBuilder(Customer custOwner,Manager recipient, IssueType issueType) {
            try {
                issueTicketsCreated += 1;
                reportID = issueTicketsCreated;
            }
            catch(NullPointerException e) {
                issueTicketsCreated = 1;
                reportID = issueTicketsCreated;
            }
            this.dateTime = LocalDateTime.now();
            this.isResolved = false;
            this.custOwner = custOwner;
            this.recipient = recipient;
            this.issueType = issueType;
            this.response = "Awaiting response from representative";
			
		}
		public IssueTicketBuilder name(String name) {
			this.name= name;
			return this;
		}
		public IssueTicketBuilder description(String description) {
			this.description = description;
			return this;
		}
		//Return the finally consrcuted User object
		public IssueTicket build() {
			IssueTicket ticket =  new IssueTicket(this);
			validateUserObject(ticket);
			return ticket;
		}
		private void validateUserObject(IssueTicket ticket) {
			//Do some basic validations to check
			//if user object does not break any assumption of system
		}

	}
}

