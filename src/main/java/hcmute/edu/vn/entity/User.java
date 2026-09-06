package hcmute.edu.vn.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Users")
@SuppressWarnings("serial")
public class User implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String userName;
    private String fullName;
    private String password;
    private String avatar;
    private int roleId;
    private String phone;
    private Date createdDate;
    private String images;
    
    @Column(name = "otp_code")
    private String otpCode;
    
    @Column(name = "otp_expiry")
    @Temporal(TemporalType.TIMESTAMP)
    private Date otpExpiry;
    
    @Column(name = "is_active")
    private boolean isActive;

    // Constructor mặc định
    public User() {
    }

    // Constructor đầy đủ tham số
    public User(int id, String email, String userName, String fullName, String password, String avatar, int roleId, String phone, Date createdDate) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.avatar = avatar;
        this.roleId = roleId;
        this.phone = phone;
        this.createdDate = createdDate;
    }

    // Getters và Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullname) {
        this.fullName = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }

    public Date getOtpExpiry() {
        return otpExpiry;
    }

    public void setOtpExpiry(Date otpExpiry) {
        this.otpExpiry = otpExpiry;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

	public Object getUserName() {
		return userName;
	}

	public int getRoleid() {
		return roleId;
	}
}