package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity //Para o JPA reconhecer como entidade
@Table(name = "tb_product")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "id.product") //Para mostrar qual FK ele se relaciona
	private Set<OrderItem> items = new HashSet<>();
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Para ser o autoincrement no DB
	private Long id;
	private String name;
	private String description;
	private Double Price;
	private String imgUrl;
	
	@ManyToMany  
	@JoinTable(name = "tb_product_category",
	joinColumns = @JoinColumn(name = "product_id"), //Foreign key do producto
	inverseJoinColumns = @JoinColumn(name = "category_id")) //Foreign key da categoria
	private Set<Category> categories = new HashSet<>(); //É pra garantir que a coleção não comece nula.
	
	public Product() {
		
	}

	//Coleção nn vai no instrutor pq ela é instanciada acima
	public Product(Long id, String name, String description, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		Price = price;
		this.imgUrl = imgUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		return categories;
	}
	
	@JsonIgnore
	public Set<Order> getOrders(){
		//Vai percorrer todos os itens, adicionar o Order deles e retornar isso
		Set<Order> set = new HashSet<>();
		for(OrderItem x : items) {
			set.add(x.getOrder());
		}
		return set;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

	
	
}
