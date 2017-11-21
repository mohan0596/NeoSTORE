package com.example.root.neostore.model.OrderModel.orderDetail;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class OrderData {

	@SerializedName("cost")
	private int cost;

	@SerializedName("address")
	private String address;

	@SerializedName("id")
	private int id;

	@SerializedName("order_details")
	private List<OrderDetailsItem> orderDetails;

	public void setCost(int cost){
		this.cost = cost;
	}

	public int getCost(){
		return cost;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setOrderDetails(List<OrderDetailsItem> orderDetails){
		this.orderDetails = orderDetails;
	}

	public List<OrderDetailsItem> getOrderDetails(){
		return orderDetails;
	}

	@Override
 	public String toString(){
		return 
			"OrderData{" +
			"cost = '" + cost + '\'' + 
			",address = '" + address + '\'' + 
			",id = '" + id + '\'' + 
			",order_details = '" + orderDetails + '\'' + 
			"}";
		}
}