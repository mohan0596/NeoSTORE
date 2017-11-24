package com.example.root.neostore.model.CartModel.DeleteCartModel;


import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class DeleteCartModel implements Serializable
    {

        @SerializedName("status")
        @Expose
        private Long status;
        @SerializedName("data")
        @Expose
        private Boolean data;
        @SerializedName("total_carts")
        @Expose
        private Long totalCarts;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("user_msg")
        @Expose
        private String userMsg;
        private final static long serialVersionUID = -7131555781934700741L;


        public DeleteCartModel() {
        }


        public DeleteCartModel(Long status, Boolean data, Long totalCarts, String message, String userMsg) {
            super();
            this.status = status;
            this.data = data;
            this.totalCarts = totalCarts;
            this.message = message;
            this.userMsg = userMsg;
        }

        public Long getStatus() {
            return status;
        }

        public void setStatus(Long status) {
            this.status = status;
        }

        public Boolean getData() {
            return data;
        }

        public void setData(Boolean data) {
            this.data = data;
        }

        public Long getTotalCarts() {
            return totalCarts;
        }

        public void setTotalCarts(Long totalCarts) {
            this.totalCarts = totalCarts;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getUserMsg() {
            return userMsg;
        }

        public void setUserMsg(String userMsg) {
            this.userMsg = userMsg;
        }

        @Override
        public String toString() {
            return "DeleteCartModel{" +
                    "status=" + status +
                    ", data=" + data +
                    ", totalCarts=" + totalCarts +
                    ", message='" + message + '\'' +
                    ", userMsg='" + userMsg + '\'' +
                    '}';
        }
    }



