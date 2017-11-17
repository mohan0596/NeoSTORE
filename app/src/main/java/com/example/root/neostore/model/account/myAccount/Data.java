package com.example.root.neostore.model.account.myAccount;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("total_carts")
	private int totalCarts;

	@SerializedName("product_categories")
	private List<ProductCategoriesItem> productCategories;

	@SerializedName("user_data")
	private UserData userData;

	@SerializedName("total_orders")
	private int totalOrders;

	public void setTotalCarts(int totalCarts){
		this.totalCarts = totalCarts;
	}

	public int getTotalCarts(){
		return totalCarts;
	}

	public void setProductCategories(List<ProductCategoriesItem> productCategories){
		this.productCategories = productCategories;
	}

	public List<ProductCategoriesItem> getProductCategories(){
		return productCategories;
	}

	public void setUserData(UserData userData){
		this.userData = userData;
	}

	public UserData getUserData(){
		return userData;
	}

	public void setTotalOrders(int totalOrders){
		this.totalOrders = totalOrders;
	}

	public int getTotalOrders(){
		return totalOrders;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"total_carts = '" + totalCarts + '\'' + 
			",product_categories = '" + productCategories + '\'' + 
			",user_data = '" + userData + '\'' + 
			",total_orders = '" + totalOrders + '\'' + 
			"}";
		}
}