package falah.falah_api.controller;

import com.google.gson.Gson;
import falah.falah_api.config.EmailUtil;
import falah.falah_api.model.UserProfile;
import falah.falah_api.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
public class UserProfileController {
    @Autowired
    UserProfileRepository userProfileRepository;
    UserProfile userProfile;
    @CrossOrigin
    @GetMapping("/api/userProfile")
    public List<UserProfile> userList(){
        return userProfileRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/api/userProfile/{id}")
    public UserProfile show(@PathVariable String id){
        long userId = Integer.parseInt(id);
        return userProfileRepository.findById(userId).get();
    }

    @CrossOrigin
    @PostMapping("/api/userProfile")
    public int create(@RequestParam("userProfile") Object body, @RequestParam(value="userPic",required=false) MultipartFile file) {
        try {
            Gson gson = new Gson();
            userProfile = gson.fromJson(body.toString(), UserProfile.class);

            if(file.getSize() > 0){
                String BasicBase64format = Base64.getEncoder().encodeToString(file.getBytes());
                userProfile.setPicFileName(file.getOriginalFilename());
                userProfile.setPicContentType(file.getContentType());
                userProfile.setUserPic("data:" + file.getContentType() +";base64," + BasicBase64format);
            }

            userProfile.setCreatedOn(LocalDateTime.now());
            userProfileRepository.save(userProfile);
            EmailUtil.sendEmail(userProfile.getUserEmail(),"Registration confirmation", "Congratulation. You are successfully registered in falah." + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "On behalf of" + "\r\n" + "falahchemnitz team" );
        }
        catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @CrossOrigin
    @PostMapping("/api/userProfile/{id}")
    //public void update(@RequestBody UserProfile body){
    public int update(@RequestParam("userProfile") Object body, @RequestParam(value="userPic",required=false) MultipartFile file) {
        try {
            Gson gson = new Gson();
            userProfile = gson.fromJson(body.toString(), UserProfile.class);
            if(!(userProfile.getUserId() > 0))
                return 0;

            if(file.getSize() > 0){
                String BasicBase64format = Base64.getEncoder().encodeToString(file.getBytes());
                userProfile.setPicFileName(file.getOriginalFilename());
                userProfile.setPicContentType(file.getContentType());
                userProfile.setUserPic("data:" + file.getContentType() +";base64," + BasicBase64format);
            }

            String currentUserEmail = userProfileRepository.getUserEmailByUserId(userProfile.getUserId());
            if(currentUserEmail != userProfile.getUserEmail()){
                EmailUtil.sendEmail(userProfile.getUserEmail(),"Registration confirmation", "Congratulation. You have successfully modified your email in falah." + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "On behalf of" + "\r\n" + "falahchemnitz team" );
            }

            userProfile.setCreatedOn(LocalDateTime.now());
            userProfileRepository.save(userProfile);
        }
        catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @CrossOrigin
    @DeleteMapping("/api/userProfile/{id}")
    public int delete(@PathVariable String id){
        try {
            long userId = Integer.parseInt(id);
            userProfileRepository.deleteById(userId);
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }
}
