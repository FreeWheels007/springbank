package springTest.bankManagerApp.account;

import springTest.bankManagerApp.profile.Profile;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class ChequingAccount extends Account {
    private Boolean hasOverdraft;
    private Float monthlyFee;

    public ChequingAccount() {
        super();
    }

    public ChequingAccount(String name, LocalDate doc, Float balance, Boolean hasOverdraft, Float monthlyFee) {
        super(name, doc, balance);
        this.hasOverdraft = hasOverdraft;
        this.monthlyFee = monthlyFee;
    }

    public ChequingAccount(Profile owner, String name, LocalDate doc, Float balance, Boolean hasOverdraft, Float monthlyFee) {
        super(owner, name, doc, balance);
        this.hasOverdraft = hasOverdraft;
        this.monthlyFee = monthlyFee;
    }

    public Boolean getHasOverdraft() {
        return hasOverdraft;
    }

    public void setHasOverdraft(Boolean hasOverdraft) {
        this.hasOverdraft = hasOverdraft;
    }

    public Float getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(Float monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    @Override
    public String toString() {
        return "ChequingAccount{" +
                "balance=" + this.getBalance() +
                ", hasOverdraft=" + hasOverdraft +
                ", " + super.toString() +
                '}';
    }
}
