package com.example.root.neostore.model.RatingModel;

import com.example.root.neostore.common.Base.BaseModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 16/11/17.
 */

public class RatingResponse extends BaseModel {
    @SerializedName("id")
    private  int id;

    @SerializedName("product_category_id")
    private int product_category_id;
    @SerializedName("name")
    private String name;
    @SerializedName("producer")
    private String producer;
    @SerializedName("description")
    private String description;
    @SerializedName("cost")
    private int cost;
    @SerializedName("rating")
    private int rating;
    @SerializedName("view_count")
    private int view_count;
    @SerializedName("product_images")
    private String product_images;
    @SerializedName("created")
    private String created;
    @SerializedName("modified")
    private String modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_category_id() {
        return product_category_id;
    }

    public void setProduct_category_id(int product_category_id) {
        this.product_category_id = product_category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public String getProduct_images() {
        return product_images;
    }

    public void setProduct_images(String product_images) {
        this.product_images = product_images;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }
}
