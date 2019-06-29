package com.objis.cam.sgethymleaf.dao;

import java.util.Date;

public class UserDTO {

	public Long getUserRole() {
		return userRole;
	}

	public void setUserRole(Long userRole) {
		this.userRole = userRole;
	}

	private Long userRole;
    private String userName;
    private String encrytedPassword;
    
    private String matricule;
    private String firstName;
	private String lastName;
	private Date date;
	private String gender;
	private String email;
	private boolean enabled;

 
    public UserDTO() {
 
    }
 
    public UserDTO(Long userRole, String userName, String encrytedPassword) {
        this.userRole = userRole;
        this.userName = userName;
        this.encrytedPassword = encrytedPassword;
    }
 
	
	public UserDTO(Long userRole, String userName, String encrytedPassword, String matricule, String firstName,
			String lastName, Date date, String gender, String email, boolean enabled) {
		super();
		this.userRole = userRole;
		this.userName = userName;
		this.encrytedPassword = encrytedPassword;
		this.matricule = matricule;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.gender = gender;
		this.email = email;
		this.enabled = enabled;
	}
	
	
	
	

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
	
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getEncrytedPassword() {
        return encrytedPassword;
    }
 
    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }
    

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}