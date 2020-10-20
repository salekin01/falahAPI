package falah.falah_api.controller;

import falah.falah_api.model.Comment;
import falah.falah_api.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentRepository commentRepository;
    Comment comment;

    @CrossOrigin
    @GetMapping("/api/comment")
    public List<Comment> commentList(){
        return commentRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/api/comment/{id}")
    public Comment show(@PathVariable String id){
        long commentId = Integer.parseInt(id);
        return commentRepository.findById(commentId).get();
    }

    @CrossOrigin
    @PostMapping("/api/comment")
    public int create(@RequestBody Comment body){
        try {
            body.setCreatedOn(LocalDateTime.now());
            commentRepository.save(body);
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

    @CrossOrigin
    @PostMapping("/api/comment/{id}")
    public int update(@RequestBody Comment body){
        try {
            body.setCreatedOn(LocalDateTime.now());
            commentRepository.save(body);
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

    @CrossOrigin
    @DeleteMapping("/api/comment/{id}")
    public int delete(@PathVariable String id){
        try {
            long commentId = Integer.parseInt(id);
            commentRepository.deleteById(commentId);
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

    @CrossOrigin
    @GetMapping("/api/comment/getCommentsByBlogId/{id}")
    public List<Comment> getCommentsByBlogId(@PathVariable String id){
        long blogId = Integer.parseInt(id);
        return commentRepository.getCommentsByBlogId(blogId);
    }
}
