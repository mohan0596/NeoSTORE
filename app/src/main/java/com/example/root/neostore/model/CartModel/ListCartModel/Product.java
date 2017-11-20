package com.example.root.neostore.model.CartModel.ListCartModel;

import com.google.gson.annotations.SerializedName;

public class Product{

	@SerializedName("product_images")
	private String productImages;

	@SerializedName("cost")
	private int cost;

	@SerializedName("name")
	private String name;

	@SerializedName("sub_total")
	private int subTotal;

	@SerializedName("id")
	private int id;

	@SerializedName("product_category")
	private String productCategory;

	public void setProductImages(String productImages){
		this.productImages = productImages;
	}

	public String getProductImages(){
		return productImages;
	}

	public void setCost(int cost){
		this.cost = cost;
	}

	public int getCost(){
		return cost;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSubTotal(int subTotal){
		this.subTotal = subTotal;
	}

	public int getSubTotal(){
		return subTotal;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setProductCategory(String productCategory){
		this.productCategory = productCategory;
	}

	public String getProductCategory(){
		return productCategory;
	}

	@Override
 	public String toString(){
		return 
			"Product{" + 
			"product_images = '" + productImages + '\'' + 
			",cost = '" + cost + '\'' + 
			",name = '" + name + '\'' + 
			",sub_total = '" + subTotal + '\'' + 
			",id = '" + id + '\'' + 
			",product_category = '" + productCategory + '\'' + 
			"}";
		}
}