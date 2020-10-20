package falah.falah_api.repository;

import falah.falah_api.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    @Query("select b from Blog b where b.blogCategory.blogCategoryId = :blogCategoryId")
    List<Blog> getBlogsByBlogCategoryId(long blogCategoryId);
}
