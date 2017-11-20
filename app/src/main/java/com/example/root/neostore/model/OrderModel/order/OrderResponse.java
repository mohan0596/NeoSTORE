package com.example.root.neostore.model.OrderModel.order;

import com.google.gson.annotations.SerializedName;

public class OrderResponse{

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	@SerializedName("user_msg")
	private String userMsg;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	public void setUserMsg(String userMsg){
		this.userMsg = userMsg;
	}

	public String getUserMsg(){
		return userMsg;
	}

	@Override
 	public String toString(){
		return 
			"OrderResponse{" + 
			"message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			",user_msg = '" + userMsg + '\'' + 
			"}";
		}
}