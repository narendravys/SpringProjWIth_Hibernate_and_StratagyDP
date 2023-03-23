package com.nv.sbeans;

import java.util.Arrays;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Entity
@Table(name="amazon_orders") // table in database
@Component("amazon") // bean id
//Target Class
public final class Amazon {
	@Id
	@Column(name = "order_id")
	private int oid;
	@Column(name = "bill_Amount")
	private double billAmount;

	@Autowired
	@Qualifier("bDart") // assiging dependent to target
	@Transient
	private Courier courier; // HAS a property

	// business method
	public String addToCart(String[] products, double[] prices) {
		double billAmount = 0.0;
		for (double price : prices) {
			billAmount += price;
		}
		int oid = new Random().nextInt(100000);
		this.oid = oid;
		this.billAmount = billAmount;
		String msg = "Order no. "+courier.deliver(oid) + " having " + Arrays.toString(products) + " and Bill Amount is "
				+ billAmount;

		return msg;
	}

}
