package falah.falah_api.model;

import com.fasterxml.jackson.annotation.*;
import javassist.URLClassPath;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "blog")
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Long blogId;
    @Column(name = "blog_title")
    private String blogTitle;
    @Column(name = "blog_text")
    private String blogText;
    @Column(name = "blog_writer")
    private String blogWriter;
    @Column(name = "search_tag")
    private String searchTag;
    @Column(name = "thumbnail")
    private String thumbnail;
    @Column(name = "thumbnail_content_type")
    private String thumbnailContentType;
    @Column(name = "thumbnail_file_name")
    private String thumbnailFileName;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "fk_blog_category_id", updatable=false, insertable=false)
    private Long blogCategoryId;


    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne  //(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_blog_category_id", referencedColumnName = "blog_category_id")
    private BlogCategory blogCategory;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL) //if blog deletes, all the comments will be deleted automatically that contains the same blogId
    private List<Comment> commentList = new ArrayList<>();


    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogText() {
        return blogText;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }

    public String getBlogWriter() {
        return blogWriter;
    }

    public void setBlogWriter(String blogWriter) {
        this.blogWriter = blogWriter;
    }

    public String getSearchTag() {
        return searchTag;
    }

    public void setSearchTag(String searchTag) {
        this.searchTag = searchTag;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnailContentType() {
        return thumbnailContentType;
    }

    public void setThumbnailContentType(String thumbnailContentType) {
        this.thumbnailContentType = thumbnailContentType;
    }

    public String getThumbnailFileName() {
        return thumbnailFileName;
    }

    public void setThumbnailFileName(String thumbnailFileName) {
        this.thumbnailFileName = thumbnailFileName;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Long getBlogCategoryId() {
        return blogCategoryId;
    }

//    public void setBlogCategoryId(Long blogCategoryId) {
//        this.blogCategoryId = blogCategoryId;
//    }

//    public BlogCategory getBlogCategory() {
//        return blogCategory;
//    }

    public void setBlogCategory(BlogCategory blogCategory) {
        this.blogCategory = blogCategory;
    }
}
