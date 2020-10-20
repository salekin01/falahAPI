package falah.falah_api.repository;

import falah.falah_api.model.Blog;
import falah.falah_api.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    @Query("select u.userEmail from UserProfile u where u.userId = :userId")
    String getUserEmailByUserId(long userId);
}
