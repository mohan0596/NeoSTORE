package com.example.root.neostore.model.CartModel.QuantityModel;

import com.google.gson.annotations.SerializedName;

public class AddToCartResponse{
	@SerializedName(" total_carts")
	private int totalCarts;
	@SerializedName("data")
	private boolean data;
	@SerializedName("message")
	private String message;
	@SerializedName("status")
	private int status;
	@SerializedName("user_msg")
	private String userMsg;

	public void setTotalCarts(int totalCarts){
		this.totalCarts = totalCarts;
	}

	public int getTotalCarts(){
		return totalCarts;
	}

	public void setData(boolean data){
		this.data = data;
	}

	public boolean isData(){
		return data;
	}

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
			"AddToCartResponse{" + 
			"total_carts = '" + totalCarts + '\'' + 
			",data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			",user_msg = '" + userMsg + '\'' + 
			"}";
		}
}
