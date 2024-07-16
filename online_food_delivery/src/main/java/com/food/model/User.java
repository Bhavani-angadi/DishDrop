package com.food.model;

public class User {
		private int userId;
		private String userName;
		private String password;
		private String email;
		private String address;
		private String role;
		
		public User()
		{
			
		}
		
		public User(String userName, String password, String email, String address, String role) {
			super();
//			this.userId=userId;
			this.userName = userName;
			this.password = password;
			this.email = email;
			this.address = address;
			this.role = role;
		}
		
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		
		@Override
		public String toString() {
		
		return userId+" "+userName+" "+password+" "+address+" "+email+" "+role;
		}

}
