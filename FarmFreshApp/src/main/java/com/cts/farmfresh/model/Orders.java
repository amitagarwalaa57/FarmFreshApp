package com.cts.farmfresh.model;
public class Orders {
	private Integer orderId;
	private Integer quantitypurchase;
	private Product p;
	
	public Orders(){
		 orderId=0;
	        quantitypurchase=0;
	        setP(null);
	}
	

	public Orders(Product productById, int quantity) {
		this.p=productById;
		this.quantitypurchase=quantity;
	}


	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getQuantitypurchase() {
		return quantitypurchase;
	}

	public void setQuantitypurchase(Integer quantitypurchase) {
		this.quantitypurchase = quantitypurchase;
	}


	public Product getP() {
		return p;
	}


	public void setP(Product p) {
		this.p = p;
	} 
}
