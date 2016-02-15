package br.com.auctionapp.model;

import java.io.Serializable;
import java.util.Date;

public class Auction implements Serializable {

    private Integer id;

    private Double startingBid = 50D;
    private Double bidIncrement = 10D;
    private Date startTime;
    private Date endTime;
    private String itemDescription;
    private String itemName;
    private User seller;

    private Double actualBid;
    private User customer;

    public Auction(User seller, String itemName, Double startingBid) {
        this.seller = seller;
        this.itemName = itemName;
        this.startingBid = startingBid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStartingBid(Double startingBid) {
        this.startingBid = startingBid;
    }

    public void setBidIncrement(Double bidIncrement) {
        this.bidIncrement = bidIncrement;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getId() {
        return id;
    }

    public Double getStartingBid() {
        return startingBid;
    }

    public Double getBidIncrement() {
        return bidIncrement;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getFullDescription() {
        return itemName + "\n\n" + itemDescription + "\n\nStarting bid: " + startingBid
                + "\n\nBid increment: " + bidIncrement
                + (actualBid != null ? "\n\nActual value: " + actualBid + " (customer: " + customer + ")" :
                "\n\nActual value: There is no bidding for this yet.");
    }

    public String getItemName() {
        return itemName;
    }

    public User getSeller() {
        return seller;
    }

    public Double getActualBid() {
        return actualBid;
    }

    public User getCustomer() {
        return customer;
    }

    public void bid(User user) {
        customer = user;
        if(actualBid == null) actualBid = startingBid;
        actualBid = actualBid + bidIncrement;
    }

    public boolean isClosed() {
        if (new Date().after(endTime)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return itemName + " - Actual value: " + (actualBid==null? startingBid : actualBid)
                + (customer == null ? "" : " (customer: " + customer + ")");
    }
}
