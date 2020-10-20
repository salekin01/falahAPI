package falah.falah_api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "comment")
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;
    @Column(name = "comment_text")
    private String commentText;
    @Column(name = "commented_by")
    private String commentedBy;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "fk_blog_id", updatable=false, insertable=false)
    private Long blogId;

    @ManyToOne  //(cascade=CascadeType.MERGE)   //Foreign key   //Many comments for one blog
    @JoinColumn(name = "fk_blog_id", referencedColumnName = "blog_id")
    private Blog blog;


    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getCommentedBy() {
        return commentedBy;
    }

    public void setCommentedBy(String commentedBy) {
        this.commentedBy = commentedBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Long getBlogId() {
        return blogId;
    }

//    public void setBlogId(Long blogId) {
//        this.blogId = blogId;
//    }

//    public Blog getBlog() {
//        return blog;
//    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
