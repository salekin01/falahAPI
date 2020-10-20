package falah.falah_api.controller;

import falah.falah_api.model.Comment;
import falah.falah_api.model.Feedback;
import falah.falah_api.repository.CommentRepository;
import falah.falah_api.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class FeedbackController {
    @Autowired
    FeedbackRepository feedbackRepository;
    Feedback feedback;

    @CrossOrigin
    @GetMapping("/api/feedback")
    public List<Feedback> feedbackList(){
        return feedbackRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/api/feedback/{id}")
    public Feedback show(@PathVariable String id){
        long feedbackId = Integer.parseInt(id);
        return feedbackRepository.findById(feedbackId).get();
    }

    @CrossOrigin
    @PostMapping("/api/feedback")
    public int create(@RequestBody Feedback body){
        try {
            body.setCreatedOn(LocalDateTime.now());
            feedbackRepository.save(body);
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

    @CrossOrigin
    @PostMapping("/api/feedback/{id}")
    public int update(@RequestBody Feedback body){
        try {
            body.setCreatedOn(LocalDateTime.now());
            feedbackRepository.save(body);
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

    @CrossOrigin
    @DeleteMapping("/api/feedback/{id}")
    public int delete(@PathVariable String id){
        try {
            long feedbackId = Integer.parseInt(id);
            feedbackRepository.deleteById(feedbackId);
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }
}
