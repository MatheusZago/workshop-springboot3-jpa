package com.educandoweb.course.entities;

import java.io.Serializable;

import com.educandoweb.course.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId //Isso aqui é por ser um ID composto
	//Se for usar um Id cComposto tem que iniciar
	private OrderItemPK id = new OrderItemPK();

	private Integer quantity;
	private Double price;

	public OrderItem() {
	}

	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		//Ta setando pq vai usar o id do PK
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	@JsonIgnore //Como ele chama ele pelo Id ta colocandoa qui o método pra nn ter loop infinito
	public Order getOrder() {
		return id.getOrder();
	}

	public void setOrder(Order order) {
		id.setOrder(order);
	}

	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	//O que vale em EE é get, então tem que fazer assim
	public Double getSubTotal() {
		return price * quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}