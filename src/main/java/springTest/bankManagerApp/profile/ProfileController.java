package springTest.bankManagerApp.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

//    @GetMapping
//    public List<Profile> getProfiles() {
//        return this.profileService.getProfiles();
//    }
    @GetMapping
    public ModelAndView profile() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("profile.html");

        List<Profile> profiles = this.profileService.getProfiles();
        mav.addObject("profiles", profiles);
        return mav;
    }

    @PostMapping
    public void registerNewProfile(@RequestBody Profile profile) {
        this.profileService.addProfile(profile);
    }
}
