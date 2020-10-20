package falah.falah_api.repository;

import falah.falah_api.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c where c.blog.blogId = :blogId")
    public List<Comment> getCommentsByBlogId(@Param("blogId") long blogId);

    //doesn't work
    @Modifying(clearAutomatically=true, flushAutomatically=true)
    @Query("delete from Comment c where c.blog.blogId = :blogId")
    public void deleteCommentsByBlogId(@Param("blogId") long blogId);
}
