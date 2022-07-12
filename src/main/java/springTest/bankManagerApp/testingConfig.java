package springTest.bankManagerApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springTest.bankManagerApp.account.Account;
import springTest.bankManagerApp.account.AccountRepository;
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

            Account ba1 = new Account(
                    bernie,
                    "basic account 1",
                    LocalDate.of(2005, Month.FEBRUARY, 5)
            );

            Account ba2 = new Account(
                    kitty,
                    "basic account 222222!",
                    LocalDate.of(2222, Month.FEBRUARY, 22)
            );

            accountRepository.saveAll(List.of(ba1, ba2));
        };
    }
}
