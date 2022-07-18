package springTest.bankManagerApp.transaction;

import springTest.bankManagerApp.account.Account;
import springTest.bankManagerApp.profile.Profile;

import javax.persistence.*;

@Entity
@Table
public class Transaction {
    public enum Status {COMPLETED, PENDING, DENIED}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "receiver_account_id", referencedColumnName = "id", nullable = false)
    private Account receiverAccount;
    @ManyToOne
    @JoinColumn(name = "sender_account_id", referencedColumnName = "id", nullable = false)
    private Account senderAccount;
    private String description;
    private Float amount;
    private Status status;

    public Transaction() {
    }

    public Transaction(String description, Float amount, Status status) {
        this.description = description;
        this.amount = amount;
        this.status = status;
    }

    public Transaction(Account senderAccount, Account receiverAccount, String description, Float amount, Status status) {
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.description = description;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    public Account getSenderAccount() {
        return senderAccount;
    }

    public Account getReceiverAccount() {
        return receiverAccount;
    }

    public Profile getSender() {
        return this.senderAccount.getOwner();
    }

    public Profile getReceiver() {
        return this.receiverAccount.getOwner();
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
