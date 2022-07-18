package springTest.bankManagerApp.profile;

import springTest.bankManagerApp.account.Account;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;
    // will have list to account objects
    @OneToMany(mappedBy = "owner")
    private Set<Account> accounts;

    public Profile() {
    }

    public Profile(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.accounts = new HashSet<>();
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account newAccount) {
        this.accounts.add(newAccount);
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
