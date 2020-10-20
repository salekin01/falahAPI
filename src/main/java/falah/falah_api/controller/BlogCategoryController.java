package falah.falah_api.controller;

import falah.falah_api.model.BlogCategory;
import falah.falah_api.repository.BlogCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class BlogCategoryController {
    @Autowired
    BlogCategoryRepository blogCategoryRepository;

    @CrossOrigin
    @GetMapping("/api/blogCategory")
    public List<BlogCategory> blogCategoryList(){
        return blogCategoryRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/api/blogCategory/{id}")
    public BlogCategory show(@PathVariable String id){
        long blogCategoryId = Integer.parseInt(id);
        return blogCategoryRepository.findById(blogCategoryId).get();
    }

    @CrossOrigin
    @PostMapping("/api/blogCategory")
    public int create(@RequestBody BlogCategory body){
        try {
            body.setCreatedOn(LocalDateTime.now());
            blogCategoryRepository.save(body);
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

    @CrossOrigin
    @PostMapping("/api/blogCategory/{id}")
    public int update(@RequestBody BlogCategory body){
        try {
            body.setCreatedOn(LocalDateTime.now());
            blogCategoryRepository.save(body);
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

    @CrossOrigin
    @DeleteMapping("/api/blogCategory/{id}")
    public int delete(@PathVariable String id){
        try {
            long blogCategoryId = Integer.parseInt(id);
            blogCategoryRepository.deleteById(blogCategoryId);
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }
}
