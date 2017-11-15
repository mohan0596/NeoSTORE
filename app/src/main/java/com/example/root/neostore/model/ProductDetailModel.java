package com.example.root.neostore.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductDetailModel{
	@SerializedName("data")
	private DataItem data;
	@SerializedName("status")
	private int status;

	public void setData(DataItem data){
		this.data = data;
	}

	public DataItem getData(){
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
			"ProductDetailModel{" + 
			"data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}