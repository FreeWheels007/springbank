package springTest.bankManagerApp.profile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ProfileConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProfileRepository repository) {
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

            repository.saveAll(List.of(bernie, bigbessy, kitty));
        };
    }
}
