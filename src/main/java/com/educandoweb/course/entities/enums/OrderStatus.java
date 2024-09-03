package com.educandoweb.course.entities.enums;

public enum OrderStatus {

	//Fazer assim deixa mais seguro pois define qual tipo é qual.
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3), 
	DELIVERED(4), 
	CANCELED(5);
	
	private int code;
	
	//Assim cria um construtor privado para o code
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		//Isso é uma forma de percorrer todos os valores do order Status
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid order status code.");
	}
	
}
