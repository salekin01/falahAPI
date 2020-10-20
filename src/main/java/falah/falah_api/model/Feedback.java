package falah.falah_api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "feedback")
@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Long feedbackId;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "feedback_text")
    private String feedbackText;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "fk_user_id", updatable=false, insertable=false)
    private Long userId;

                                                                        //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne                                                          //(optional = true)  //(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")  //, columnDefinition="long", nullable = true
    private UserProfile userProfile;

    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Long getUserId() {
        return userId;
    }

//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public UserProfile getUserProfile() {
//        return userProfile;
//    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
