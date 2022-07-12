package springTest.bankManagerApp.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public List<Profile> getProfiles() {
        return this.profileService.getProfiles();
    }

    @PostMapping
    public void registerNewProfile(@RequestBody Profile profile) {
        this.profileService.addProfile(profile);
    }
}
