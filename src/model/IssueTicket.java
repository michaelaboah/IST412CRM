
package model;

import java.time.LocalDateTime;
import java.util.ArrayList;


// import controller.ListCntl;


public class IssueTicket {

    

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

