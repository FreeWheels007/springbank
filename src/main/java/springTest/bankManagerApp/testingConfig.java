package springTest.bankManagerApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springTest.bankManagerApp.account.*;
import springTest.bankManagerApp.profile.Profile;
import springTest.bankManagerApp.profile.ProfileRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class testingConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProfileRepository profileRepository,
                                        AccountRepository accountRepository) {
        return args -> {
            Profile bernie = new Profile(
                    "Bernie",
                    "bern@awesome.ca",
                    LocalDate.of(1999, Month.JUNE, 14)
            );

            Profile bigbessy = new Profile(
                    "Big Bessy",
                    "bessy@gmail.com",
                    LocalDate.of(1990, Month.AUGUST, 7)
            );

            Profile kitty = new Profile(
                    "Spottedleaf",
                    "spl@kittycat.com",
                    LocalDate.of(2005, Month.DECEMBER, 25)
            );

            profileRepository.saveAll(List.of(bernie, bigbessy, kitty));

            Account ba1 = new CashSavingAccount(
                    bernie,
                    "HY TFSA cash",
                    LocalDate.of(1998, Month.APRIL, 1),
                    25000F,
                    4.4F
            );

            Account ba2 = new ChequingAccount(
                    kitty,
                    "cheqing account 222222!",
                    LocalDate.of(2222, Month.FEBRUARY, 22),
                    5874.44F,
                    false,
                    35.95F
            );

            Account ba3 = new CreditAccount(
                    bernie,
                    "cedit account unsecured",
                    LocalDate.now(),
                    8589.43F,
                    50000.00F,
                    8.5F
            );
            System.out.println(ba3.toString());

            accountRepository.saveAll(List.of(ba1, ba2, ba3));
        };
    }
}
