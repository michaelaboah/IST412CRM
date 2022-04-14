
package model;

import java.time.LocalDateTime;
import java.util.ArrayList;




public class IssueTicket {

    private String name, description;
    private Integer reportID;
    private LocalDateTime dateTime;
    private Boolean isResolved;
    // private Customer custOwner;
    // private Manager recipient;
    private IssueType issueType;
    private String response;
    private static int issueTicketsCreated;

    public IssueTicket(String name, String description, Integer reportID, LocalDateTime dateTime, Boolean isResolved,
            IssueType issueType, String response) {
        this.name = name;
        this.description = description;
        this.reportID = reportID;
        this.dateTime = dateTime;
        this.isResolved = isResolved;
        this.issueType = issueType;
        this.response = response;
    }

    public IssueTicket() {
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
    @Override
    public String toString() {
        return "IssueTicket [dateTime=" + dateTime + ", description=" + description + ", isResolved=" + isResolved
                + ", issueType=" + issueType + ", name=" + name + ", reportID=" + reportID + ", response=" + response
                + "]";
    }


    public String getExtra() {

        return "extra";
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

