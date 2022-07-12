package springTest.bankManagerApp.account;

import springTest.bankManagerApp.profile.Profile;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.time.LocalDate;

@Entity
public class CreditAccount extends Account {
    private Float creditLimit;
    private Float interestRate;
    @Transient
    private Float minDue;

    public CreditAccount() {
    }

    public CreditAccount(Profile owner, String name, LocalDate doc, Float balance, Float creditLimit, Float interestRate) {
        super(owner, name, doc, balance);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    // calculate the min payment due, based off of common loc rules
    public Float getMinDue() {
        float minDue = (float) 50.00;
        float interestMonthly = (float) (this.getBalance() * interestRate * 0.01 / 12.0);

        if (this.getBalance() < minDue) return this.getBalance();
        else return Math.max(interestMonthly, minDue);
        }

    public Float getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Float creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Float interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                ", creditLimit=" + creditLimit +
                ", interestRate=" + interestRate +
                ", minDue=" + minDue +
                ", " + super.toString() +
                '}';
    }
}
