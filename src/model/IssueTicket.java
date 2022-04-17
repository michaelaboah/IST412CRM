
package model;

import java.time.LocalDateTime;
import java.util.ArrayList;




public class IssueTicket {

    private String description;
    private Integer reportID;
    private LocalDateTime dateTime;
    private Boolean isResolved;
    private Integer custID;
    // private Manager recipient;
    private Integer orderID;
    private String response;
    private static int issueTicketsCreated;

    public IssueTicket(String description, Integer reportID, LocalDateTime dateTime, Boolean isResolved,
            Integer orderID, String response, Integer custID) {
        this.description = description;
        this.reportID = reportID;
        this.dateTime = dateTime;
        this.isResolved = isResolved;
        this.orderID = orderID;
        this.response = response;
        this.custID = custID;
    }

    public IssueTicket() {
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
    public Integer getOrderID() {
        return orderID;
    }
    public void setIssueType(Integer orderID) {
        this.orderID = orderID;
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
    public Integer getCustID() {
        return custID;
    }
    public void setCustID(Integer custID) {
        this.custID = custID;
    }

    @Override
    public String toString() {
        return "IssueTicket [dateTime=" + dateTime + ", description=" + description + ", isResolved=" + isResolved
                + ", orderID=" + orderID + ", reportID=" + reportID + ", response=" + response
                + "]";
    }
}

//     public static class IssueTicketBuilder
// 	{
// 		private String name, description;
//         private Integer reportID;
//         private LocalDateTime dateTime;
//         private Boolean isResolved;
//         private Customer custOwner;
//         private Manager recipient;
//         private IssueType issueType;
//         private String response;
//         private static int issueTicketsCreated;

// 		public IssueTicketBuilder(Customer custOwner,Manager recipient, IssueType issueType) {
//             try {
//                 issueTicketsCreated += 1;
//                 reportID = issueTicketsCreated;
//             }
//             catch(NullPointerException e) {
//                 issueTicketsCreated = 1;
//                 reportID = issueTicketsCreated;
//             }
//             this.dateTime = LocalDateTime.now();
//             this.isResolved = false;
//             this.custOwner = custOwner;
//             this.recipient = recipient;
//             this.issueType = issueType;
//             this.response = "Awaiting response from representative";
			
// 		}
// 		public IssueTicketBuilder name(String name) {
// 			this.name= name;
// 			return this;
// 		}
// 		public IssueTicketBuilder description(String description) {
// 			this.description = description;
// 			return this;
// 		}
// 		//Return the finally consrcuted User object
// 		// public IssueTicket build() {
// 		// 	IssueTicket ticket =  new IssueTicket(this);
// 		// 	validateUserObject(ticket);
// 		// 	return ticket;
// 		// }
// 		private void validateUserObject(IssueTicket ticket) {
// 			//Do some basic validations to check
// 			//if user object does not break any assumption of system
// 		}

// 	}
// }
