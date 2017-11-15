package com.example.root.neostore.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataItem{
	@SerializedName("product_images")
	private List<ProductImagesItem> productImages;
	@SerializedName("cost")
	private int cost;
	@SerializedName("created")
	private String created;
	@SerializedName("name")
	private String name;
	@SerializedName("rating")
	private int rating;
	@SerializedName("producer")
	private String producer;
	@SerializedName("description")
	private String description;
	@SerializedName("modified")
	private String modified;
	@SerializedName("id")
	private int id;
	@SerializedName("view_count")
	private int viewCount;
	@SerializedName("product_category_id")
	private int productCategoryId;

	public void setProductImages(List<ProductImagesItem> productImages){
		this.productImages = productImages;
	}

	public List<ProductImagesItem> getProductImages(){
		return productImages;
	}

	public void setCost(int cost){
		this.cost = cost;
	}

	public int getCost(){
		return cost;
	}

	public void setCreated(String created){
		this.created = created;
	}

	public String getCreated(){
		return created;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setRating(int rating){
		this.rating = rating;
	}

	public int getRating(){
		return rating;
	}

	public void setProducer(String producer){
		this.producer = producer;
	}

	public String getProducer(){
		return producer;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setModified(String modified){
		this.modified = modified;
	}

	public String getModified(){
		return modified;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setViewCount(int viewCount){
		this.viewCount = viewCount;
	}

	public int getViewCount(){
		return viewCount;
	}

	public void setProductCategoryId(int productCategoryId){
		this.productCategoryId = productCategoryId;
	}

	public int getProductCategoryId(){
		return productCategoryId;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"product_images = '" + productImages + '\'' + 
			",cost = '" + cost + '\'' + 
			",created = '" + created + '\'' + 
			",name = '" + name + '\'' + 
			",rating = '" + rating + '\'' + 
			",producer = '" + producer + '\'' + 
			",description = '" + description + '\'' + 
			",modified = '" + modified + '\'' + 
			",id = '" + id + '\'' + 
			",view_count = '" + viewCount + '\'' + 
			",product_category_id = '" + productCategoryId + '\'' + 
			"}";
		}
}