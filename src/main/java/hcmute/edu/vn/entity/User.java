package hcmute.edu.vn.entity;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class User implements Serializable {
    private int id;
    private String email;
    private String userName;
    private String fullName;
    private String password;
    private String avatar;
    private int roleid;
    private String phone;
    private Date createdDate;

    // Constructor mặc định
    public User() {
    }

    // Constructor đầy đủ tham số
    public User(int id, String email, String userName, String fullName, String password, String avatar, int roleid, String phone, Date createdDate) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.avatar = avatar;
        this.roleid = roleid;
        this.phone = phone;
        this.createdDate = createdDate;
    }

    // Getters và Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPassword() { return password; }
    public void setPassWord(String password) { this.password = password; } // Chú ý chuẩn hóa tên hàm setPassword nếu cần

    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }

    public int getRoleid() { return roleid; }
    public void setRoleid(int roleid) { this.roleid = roleid; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

	public void setImages(String fileName) {
		// TODO Auto-generated method stub
		
	}
}