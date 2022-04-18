
package model;

import java.time.LocalDateTime;


/**
 * Object representation of the customers' issue they have with a product/service
 * 
 * @author Michael Aboah, Nathan Carr, Lamees Eltohami, Henry Hoffman, Liam Kirkland, Edwin Reyes Rodriguez
 * @version 04/17/22
 * 
 */
public class IssueTicket {

    private String description;
    private Integer reportID;
    private LocalDateTime dateTime;
    private Boolean isResolved;
    private Integer custID;
    private Integer orderID;
    private String response;
    private static int issueTicketsCreated;


    /**
     * Create constructor for IssueTicket
     * 
     * @param description   String text field of the customer's full complaint message
     * @param reportID      Integer representation of specific identification number for a given issueTicket
     * @param dateTime      LocalDateTime used to capture when the customer submitted the complaint
     * @param isResolved    Boolean used to determine if the matter has been resolved
     * @param orderID       Integer used to identify the customer's order/s
     * @param response      String text field of the CRM manager's full response message
     * @param custID        Integer representation of customer's documented Forest identification number for a given issue
     */
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


        StringBuilder sb = new StringBuilder();

        sb.append("IssueTicket [dateTime=").append(dateTime).append(", description=").append(description)
        .append(", isResolved=").append(isResolved).append(", orderID=").append(orderID)
        .append(", reportID=").append(reportID).append(", response=").append(response).append("]");

        return sb.toString();

    }
}
