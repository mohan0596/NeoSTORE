package com.example.root.neostore.model.OrderModel;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class OrderListModel{

	@SerializedName("data")
	private List<OrderData> data;

	@SerializedName("status")
	private int status;

	public void setData(List<OrderData> data){
		this.data = data;
	}

	public List<OrderData> getData(){
		return data;
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
			"OrderListModel{" + 
			"data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}