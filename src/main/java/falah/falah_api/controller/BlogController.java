package falah.falah_api.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import falah.falah_api.model.Blog;
import falah.falah_api.repository.BlogRepository;
import falah.falah_api.repository.CommentRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.Registration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

@RestController
public class BlogController {
    @Autowired
    BlogRepository blogRepository;
    Blog blog;

    @CrossOrigin
    @GetMapping("/api/blog")
    public List<Blog> blogList() {
        return blogRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/api/blog/{id}")
    public Blog show(@PathVariable String id) {
        long blogId = Integer.parseInt(id);
        blog = blogRepository.findById(blogId).get();
        return blog;

        //For testing purpose
        /*
        try {
            FileOutputStream out = new FileOutputStream("D:/test/hi.jpg");
            out.write(blog.getThumbnail());
        } catch (IOException ex) {
            ex.printStackTrace();
        }  */
    }

    @CrossOrigin
    @PostMapping("/api/blog")
    public int create(@RequestParam("blog") Object body, @RequestParam(value = "thumbnail",required = false) MultipartFile file) {
        try {
            Gson gson = new Gson();
            blog = gson.fromJson(body.toString(), Blog.class);

            if(file.getSize() > 0){
                String BasicBase64format = Base64.getEncoder().encodeToString(file.getBytes());
                blog.setThumbnailFileName(file.getOriginalFilename());
                blog.setThumbnailContentType(file.getContentType());
                blog.setThumbnail("data:" + file.getContentType() +";base64," + BasicBase64format);
                //blog.setThumbnail("data:image/jpeg;base64," + BasicBase64format);
            }

            blog.setCreatedOn(LocalDateTime.now());
            blogRepository.save(blog);
        }
        catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @CrossOrigin
    @PostMapping("/api/blog/{id}")
    //public void update(@RequestBody Blog body) {
    public int update(@RequestParam("blog") Object body, @RequestParam(value = "thumbnail",required=false) MultipartFile file) {
        try {
            Gson gson = new Gson();
            blog = gson.fromJson(body.toString(), Blog.class);
            if(!(blog.getBlogId() > 0))
                return 0;

            if(file.getSize() > 0){
                String BasicBase64format = Base64.getEncoder().encodeToString(file.getBytes());
                blog.setThumbnailFileName(file.getOriginalFilename());
                blog.setThumbnailContentType(file.getContentType());
                blog.setThumbnail("data:" + file.getContentType() +";base64," + BasicBase64format);
                //blog.setThumbnail("data:image/jpeg;base64," + BasicBase64format);
            }

            blog.setCreatedOn(LocalDateTime.now());
            blogRepository.save(blog);
        }
        catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @CrossOrigin
    @DeleteMapping("/api/blog/{id}")
    public int delete(@PathVariable String id) {
        try {
            long blogId = Integer.parseInt(id);
            blogRepository.deleteById(blogId);
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

    @CrossOrigin
    @GetMapping("/api/blog/getBlogsByBlogCategoryId/{id}")
    public List<Blog> getBlogsByBlogCategoryId(@PathVariable String id) {
        long blogCategoryId = Long.parseLong(id);
        return blogRepository.getBlogsByBlogCategoryId(blogCategoryId);
    }
}
