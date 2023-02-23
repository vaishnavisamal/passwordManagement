package dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PasswordData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique=true, nullable=false)
	private String email;
	private String password;
	private String fb_password;
	private String gmail_password;
	private String insta_password;
	private String linkedin_password;
	private long phone_num;
	private String role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getFb_password() {
		return fb_password;
	}
	public void setFb_password(String fb_password) {
		this.fb_password = fb_password;
	}
	public String getGmail_password() {
		return gmail_password;
	}
	public void setGmail_password(String gmail_password) {
		this.gmail_password = gmail_password;
	}
	public String getInsta_password() {
		return insta_password;
	}
	public void setInsta_password(String insta_password) {
		this.insta_password = insta_password;
	}
	public String getLinkedin_password() {
		return linkedin_password;
	}
	public void setLinkedin_password(String linkedin_password) {
		this.linkedin_password = linkedin_password;
	}
	public long getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(long phone_num) {
		this.phone_num = phone_num;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	

}
