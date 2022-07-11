package springTest.bankManagerApp.profile;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class ProfileService {
    @GetMapping
    public List<Profile> getProfiles() {
        return List.of(new Profile(
                1L,
                "Bernie",
                "bern@awesome.ca",
                LocalDate.of(1999, Month.JUNE, 14),
                50
        ));
    }
}
