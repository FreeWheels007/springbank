package springTest.bankManagerApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springTest.bankManagerApp.account.*;
import springTest.bankManagerApp.profile.Profile;
import springTest.bankManagerApp.profile.ProfileRepository;
import springTest.bankManagerApp.transaction.Transaction;
import springTest.bankManagerApp.transaction.TransactionRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class testingConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProfileRepository profileRepository,
                                        AccountRepository accountRepository,
                                        TransactionRepository transactionRepository) {
        return args -> {
            System.out.println("begin cmd line program");
            Profile bernie = new Profile(
                    "Bernie",
                    "bern@awesome.ca",
                    LocalDate.of(1999, Month.JUNE, 14)
            );

            Profile kitty = new Profile(
                    "Spottedleaf",
                    "spl@kittycat.com",
                    LocalDate.of(2005, Month.DECEMBER, 25)
            );

            CashSavingAccount bernie_csa = new CashSavingAccount(
                    "HY TFSA cash",
                    LocalDate.of(1998, Month.APRIL, 1),
                    25000F,
                    4.4F
            );
            bernie.addAccount(bernie_csa);

            ChequingAccount kitty_cheque = new ChequingAccount(
                    "cheqing account 222222!",
                    LocalDate.of(2222, Month.FEBRUARY, 22),
                    5874.44F,
                    false,
                    35.95F
            );
            kitty.addAccount(kitty_cheque);

            CreditAccount bernie_credit = new CreditAccount(
                    "cedit account unsecured",
                    LocalDate.now(),
                    8589.43F,
                    50000.00F,
                    8.5F
            );
            bernie.addAccount(bernie_credit);
            //profileRepository.saveAll(List.of(bernie, kitty));

            Transaction t1 = new Transaction("t1 test",60.0F,Transaction.Status.COMPLETED);
            bernie_csa.addDebit(t1);
            kitty_cheque.addCredit(t1);
            Transaction t2 = new Transaction("t2 test",2500F,Transaction.Status.DENIED);
            kitty_cheque.addDebit(t2);
            bernie_credit.addCredit(t2);

            System.out.println("save all to db");

            profileRepository.saveAll(List.of(bernie, kitty));
            //accountRepository.saveAll(List.of(bernie_credit,bernie_csa,kitty_cheque));
            //transactionRepository.saveAll(List.of(t1,t2));
        };
    }
}
