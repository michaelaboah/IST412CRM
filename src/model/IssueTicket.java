package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

import controller.ListCntl;


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

        this.reportID = 1234;
        this.dateTime = LocalDateTime.of(2017, 1, 14, 10, 34);
        this.name = "name";
        this.custOwner = new Customer();
        this.isResolved = false;
        this.description = "description";
        this.recipient = new Manager();
        this.issueType = IssueType.PRODUCT;
        this.response = "Awaiting response from representative,";
        try {
            issueTicketList.add(this);
        }
        catch(NullPointerException e) {
            issueTicketList = new ArrayList<>();
            issueTicketList.add(this);
        }
    }

    public Integer getReportID() {
        return reportID;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Boolean getIsResolved() {
        return isResolved;
    }

    public String getDescription() {
        return description;
    }

    public Customer getCustOwner() {
        return this.custOwner;
    }

    public Manager getRecipient() {
        return this.recipient;
    }

    public IssueType getIssueType() {
        return this.issueType;
    }

    public String getResponse() {
        return this.response;
    }

    public static ArrayList<IssueTicket> getIssueTicketList() {
        return IssueTicket.issueTicketList;
    }

    public static void printTicketList() {
        String listStr = "Issue Ticket List: \n";
        for (int i = 0; issueTicketList.size(); i++) {
            listStr += issueTicketList.get(i).getName() + "\n";
        }
        System.out.println(listStr);
    }

    @Override
    public String toString() {

        return "id: " + getReportID() + "date/time of issue: " + getDateTime()
                + "name: " + getName() + " email: " + custOwner.getEmail()
                + " resolved status: " + getIsResolved() + "issue type: "
                + getIssueType() + " description: " + getDescription();

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
