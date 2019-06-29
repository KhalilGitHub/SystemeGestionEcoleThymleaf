package com.objis.cam.sgethymleaf.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="app_user")
public class App_User {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
	
	 	private Long userId;
	    private String userName;
	    private String encrytedPassword;
	    
	    private String matricule;
	    private String firstName;
		private String lastName;
		private Date date;
		private String gender;
		private String email;
		private boolean enabled;
	
	 
	    public App_User() {
	 
	    }
	 
	    public App_User(Long userId, String userName, String encrytedPassword) {
	        this.userId = userId;
	        this.userName = userName;
	        this.encrytedPassword = encrytedPassword;
	    }
	 
		
		public App_User(Long userId, String userName, String encrytedPassword, String matricule, String firstName,
				String lastName, Date date, String gender, String email, boolean enabled) {
			super();
			this.userId = userId;
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
		
		
		
		

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public Long getUserId() {
	        return userId;
	    }
	 
	    public void setUserId(Long userId) {
	        this.userId = userId;
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
	    
	    
	 
	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		@Override
	    public String toString() {
	        return this.userName + "/" + this.encrytedPassword;
	    }
	 
	}