package com.example.root.neostore.model.OrderModel.orderList;

import com.google.gson.annotations.SerializedName;

public class OrderData {

	@SerializedName("cost")
	private double cost;

	@SerializedName("created")
	private String created;

	@SerializedName("id")
	private int id;

	public void setCost(double cost){
		this.cost = cost;
	}

	public double getCost(){
		return cost;
	}

	public void setCreated(String created){
		this.created = created;
	}

	public String getCreated(){
		return created;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return
			"OrderData{" +
			"cost = '" + cost + '\'' +
			",created = '" + created + '\'' +
			",id = '" + id + '\'' +
			"}";
		}
}