package com.example.root.neostore.model.user;

import com.google.gson.annotations.SerializedName;

public class ChangePasswd{

	@SerializedName("old_password")
	private String oldPassword;

	@SerializedName("password")
	private String password;

	@SerializedName("confirm_password")
	private String confirmPassword;

	public void setOldPassword(String oldPassword){
		this.oldPassword = oldPassword;
	}

	public String getOldPassword(){
		return oldPassword;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setConfirmPassword(String confirmPassword){
		this.confirmPassword = confirmPassword;
	}

	public String getConfirmPassword(){
		return confirmPassword;
	}

	@Override
 	public String toString(){
		return 
			"ChangePasswd{" + 
			"old_password = '" + oldPassword + '\'' + 
			",password = '" + password + '\'' + 
			",confirm_password = '" + confirmPassword + '\'' + 
			"}";
		}
}