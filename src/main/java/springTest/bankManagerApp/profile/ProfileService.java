package springTest.bankManagerApp.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @GetMapping
    public List<Profile> getProfiles() {
        return this.profileRepository.findAll();
    }

    public void addProfile(Profile profile) {
        System.out.println(profile.toString());
        Optional<Profile> profileByEmail = this.profileRepository.findProfileByEmail(profile.getEmail());

        if (profileByEmail.isPresent()) {
            throw new IllegalStateException("This email is taken!");
        }
        this.profileRepository.save(profile);
    }
}
