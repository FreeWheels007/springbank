package springTest.bankManagerApp.account;

import springTest.bankManagerApp.profile.Profile;
import springTest.bankManagerApp.transaction.Transaction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = true)
    private Profile owner;
    private String name;
    private LocalDate doc;
    private Float balance;
    // transaction history
    @OneToMany(mappedBy = "receiverAccount")
    private Set<Transaction> debitTransactions;
    @OneToMany(mappedBy = "senderAccount")
    private Set<Transaction> creditTransactions;


    public Account() {
    }

    public Account(String name, LocalDate doc, Float balance) {
        this.name = name;
        this.doc = doc;
        this.balance = balance;
        this.debitTransactions = new HashSet<>();
        this.creditTransactions = new HashSet<>();
    }

    public Account(Profile owner, String name, LocalDate doc, Float balance) {
        this.owner = owner;
        this.name = name;
        this.doc = doc;
        this.balance = balance;
        this.debitTransactions = new HashSet<>();
        this.creditTransactions = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getOwner() {
        return owner;
    }

    public void setOwner(Profile owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDoc() {
        return doc;
    }

    public void setDoc(LocalDate doc) {
        this.doc = doc;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Set<Transaction> getDebitTransactions() {
        return debitTransactions;
    }

    public Set<Transaction> getCreditTransactions() {
        return creditTransactions;
    }

    public void addDebit(Transaction debit) {
        this.debitTransactions.add(debit);
    }

    public void addCredit(Transaction credit) {
        this.creditTransactions.add(credit);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", owner=" + owner +
                ", name='" + name + '\'' +
                ", doc=" + doc +
                ", balance=" + balance +
                '}';
    }
}
