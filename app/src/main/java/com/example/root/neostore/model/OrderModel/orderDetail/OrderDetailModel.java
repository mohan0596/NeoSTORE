package com.example.root.neostore.model.OrderModel.orderDetail;

import com.google.gson.annotations.SerializedName;

public class OrderDetailModel{

	@SerializedName("data")
	private OrderData orderData;

	@SerializedName("status")
	private int status;

	public void setOrderData(OrderData orderData){
		this.orderData = orderData;
	}

	public OrderData getOrderData(){
		return orderData;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"OrderDetailModel{" + 
			"orderData = '" + orderData + '\'' +
			",status = '" + status + '\'' + 
			"}";
		}
}