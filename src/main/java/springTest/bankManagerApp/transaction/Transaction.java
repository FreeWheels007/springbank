package springTest.bankManagerApp.transaction;

import springTest.bankManagerApp.account.Account;
import springTest.bankManagerApp.profile.Profile;

import javax.persistence.*;

@Entity
@Table
public class Transaction {
    public enum Status {COMPLETED, PENDING, DENIED}
    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_sequence"
    )
    private Long id;
    private Account receiverAccount;
    private Profile receiver;
    private Account senderAccount;
    private Profile sender;
    private String description;
    private Float amount;
    private Status status;

    public Transaction() {
    }

    public Transaction(Account senderAccount, Account receiverAccount, Profile sender, Profile receiver, String description, Float amount, Status status) {
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.sender = sender;
        this.receiver = receiver;
        this.description = description;
        this.amount = amount;
        this.status = status;
    }

    public Account getSenderAccount() {
        return senderAccount;
    }

    public Account getReceiverAccount() {
        return receiverAccount;
    }

    public Profile getSender() {
        return sender;
    }

    public Profile getReceiver() {
        return receiver;
    }

    public String getDescription() {
        return description;
    }

    public Float getAmount() {
        return amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
