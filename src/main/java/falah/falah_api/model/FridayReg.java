package falah.falah_api.model;

import javax.persistence.*;

@Table(name = "friday_registration")
@Entity
public class FridayReg {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="reg_id")
  private long regId;
  @Column(name="email")
  private String email;
  @Column(name="name")
  private String name;
  @Column(name="phone_num")
  private String phoneNum;
  @Column(name="praying_slot")
  private int prayTime;
  @Column(name="consecutive_week")
  private long consecutiveWeek;
  @Column(name="registered_on")
  private java.sql.Timestamp registeredOn;
  @Column(name="valid_from")
  private java.sql.Timestamp validFrom;
  @Column(name="expire_date")

private java.sql.Timestamp expireDate;
  public long getRegId() {
    return regId;
  }

  public void setRegId(long regId) {
    this.regId = regId;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }


  public int getPrayTime() {
    return prayTime;
  }

  public void setPrayTime(int prayTime) {
    this.prayTime = prayTime;
  }


  public long getConsecutiveWeek() {
    return consecutiveWeek;
  }

  public void setConsecutiveWeek(long consecutiveWeek) {
    this.consecutiveWeek = consecutiveWeek;
  }


  public java.sql.Timestamp getRegisteredOn() {
    return registeredOn;
  }

  public void setRegisteredOn(java.sql.Timestamp registeredOn) {
    this.registeredOn = registeredOn;
  }


  public java.sql.Timestamp getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(java.sql.Timestamp validFrom) {
    this.validFrom = validFrom;
  }


  public java.sql.Timestamp getExpireDate() {
    return expireDate;
  }

  public void setExpireDate(java.sql.Timestamp expireDate) {
    this.expireDate = expireDate;
  }

}
