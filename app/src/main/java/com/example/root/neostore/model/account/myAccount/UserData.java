package com.example.root.neostore.model.account.myAccount;

import com.google.gson.annotations.SerializedName;

public class UserData{

	@SerializedName("phone_no")
	private String phoneNo;

	@SerializedName("is_active")
	private boolean isActive;

	@SerializedName("gender")
	private String gender;

	@SerializedName("created")
	private String created;

	@SerializedName("profile_pic")
	private Object profilePic;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("access_token")
	private String accessToken;

	@SerializedName("role_id")
	private int roleId;

	@SerializedName("dob")
	private Object dob;

	@SerializedName("modified")
	private String modified;

	@SerializedName("id")
	private int id;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("email")
	private String email;

	@SerializedName("country_id")
	private Object countryId;

	@SerializedName("username")
	private String username;

	public void setPhoneNo(String phoneNo){
		this.phoneNo = phoneNo;
	}

	public String getPhoneNo(){
		return phoneNo;
	}

	public void setIsActive(boolean isActive){
		this.isActive = isActive;
	}

	public boolean isIsActive(){
		return isActive;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setCreated(String created){
		this.created = created;
	}

	public String getCreated(){
		return created;
	}

	public void setProfilePic(Object profilePic){
		this.profilePic = profilePic;
	}

	public Object getProfilePic(){
		return profilePic;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setAccessToken(String accessToken){
		this.accessToken = accessToken;
	}

	public String getAccessToken(){
		return accessToken;
	}

	public void setRoleId(int roleId){
		this.roleId = roleId;
	}

	public int getRoleId(){
		return roleId;
	}

	public void setDob(Object dob){
		this.dob = dob;
	}

	public Object getDob(){
		return dob;
	}

	public void setModified(String modified){
		this.modified = modified;
	}

	public String getModified(){
		return modified;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setCountryId(Object countryId){
		this.countryId = countryId;
	}

	public Object getCountryId(){
		return countryId;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"UserData{" + 
			"phone_no = '" + phoneNo + '\'' + 
			",is_active = '" + isActive + '\'' + 
			",gender = '" + gender + '\'' + 
			",created = '" + created + '\'' + 
			",profile_pic = '" + profilePic + '\'' + 
			",last_name = '" + lastName + '\'' + 
			",access_token = '" + accessToken + '\'' + 
			",role_id = '" + roleId + '\'' + 
			",dob = '" + dob + '\'' + 
			",modified = '" + modified + '\'' + 
			",id = '" + id + '\'' + 
			",first_name = '" + firstName + '\'' + 
			",email = '" + email + '\'' + 
			",country_id = '" + countryId + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}