package springTest.bankManagerApp.account;

import springTest.bankManagerApp.profile.Profile;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class CashSavingAccount extends Account {
    private Float interestRate;

    public CashSavingAccount() {
    }

    public CashSavingAccount(String name, LocalDate doc, Float balance, Float interestRate) {
        super(name, doc, balance);
        this.interestRate = interestRate;
    }

    public CashSavingAccount(Profile owner, String name, LocalDate doc, Float balance, Float interestRate) {
        super(owner, name, doc, balance);
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "CashSavingAccount{" +
                "interestRate=" + interestRate +
                ", " + super.toString() +
                '}';
    }
}
