package falah.falah_api.controller;

import falah.falah_api.config.EmailUtil;
import falah.falah_api.model.Blog;
import falah.falah_api.model.Comment;
import falah.falah_api.model.GeneralRegistration;
import falah.falah_api.repository.BlogRepository;
import falah.falah_api.repository.GeneralRegistrationRepository;
import falah.falah_api.utils.EmailHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class GeneralRegistrationController {
    @Autowired
    GeneralRegistrationRepository registrationRepository ;
    GeneralRegistration generalRegistration;

    @CrossOrigin
    @GetMapping("/api/generalRegistration/")
    public List<GeneralRegistration> getAllRegistrationList() {
        return registrationRepository.findAll();
    }


    @CrossOrigin
    @PostMapping("/api/generalRegistration/")
    public String registration(@RequestBody GeneralRegistration body){
        try {
            EmailHelper emailHelper= new EmailHelper();
            registrationRepository.save(body);
            EmailUtil.sendEmail(body.getEmail(), "Registration Confirmation!!", "You are successfully registered for the charity week");
            return "You are successfully registered";
        }
        catch (Exception e){
            return "Something is wrong!!!";
        }
    }
}
