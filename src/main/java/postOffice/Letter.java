package postOffice;

import postOffice.person.Address;
import postOffice.person.Recipient;
import postOffice.person.Sender;

public class Letter {

    private Sender sender;
    private Recipient recipient;

    private boolean priority;
    private Status status = Status.CREATED;
    private double price;
    private Address senderAddress;
    private Address recipientAddress;

    public Letter(Sender sender, Recipient recipient, boolean priority, Address senderAddress, Address recipientAddress) {
        this.sender = sender;
        this.recipient = recipient;
        this.priority = priority;
        this.senderAddress = senderAddress;
        this.recipientAddress = recipientAddress;
    }


    public double setPrice(boolean priority){
        if(priority){
            this.price = 8.5;
            return 8.5;
        }
        this.price = 6;
        return 6;
    }

    public boolean isPriority() {
        return priority;
    }

    public double getPrice() {
        return price;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "sender=" + sender +
                ", recipient=" + recipient +

                ", priority=" + priority +
                ", status=" + status +
                ", price=" + price +
                ", senderAddress=" + senderAddress +
                ", recipientAddress=" + recipientAddress +
                '}';
    }
}
