package springTest.bankManagerApp.account;

import springTest.bankManagerApp.profile.Profile;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Account {
    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    private Long id;
    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile owner;
    private String name;
    private LocalDate doc;
    // transaction history


    public Account() {
    }

    public Account(Profile owner, String name, LocalDate doc) {
        this.owner = owner;
        this.name = name;
        this.doc = doc;
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", owner=" + owner +
                ", name='" + name + '\'' +
                ", doc=" + doc +
                '}';
    }
}
