package falah.falah_api.model;


import javax.persistence.*;

@Table(name = "general_registration")
@Entity
public class GeneralRegistration {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;
  @Column(name = "email")
  private String email;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "password")
  private String password;
  @Column(name = "role")
  private long role;
  @Column(name = "event")
  private long event;
  @Column(name = "project")
  private long project;
  @Column(name = "interest_id")
  private long interestId;
  @Column(name = "interest_sub_id")
  private long interestSubId;



  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public long getRole() {
    return role;
  }

  public void setRole(long role) {
    this.role = role;
  }


  public long getEvent() {
    return event;
  }

  public void setEvent(long event) {
    this.event = event;
  }


  public long getProject() {
    return project;
  }

  public void setProject(long project) {
    this.project = project;
  }


  public long getInterestId() {
    return interestId;
  }

  public void setInterestId(long interestId) {
    this.interestId = interestId;
  }


  public long getInterestSubId() {
    return interestSubId;
  }

  public void setInterestSubId(long interestSubId) {
    this.interestSubId = interestSubId;
  }

}
