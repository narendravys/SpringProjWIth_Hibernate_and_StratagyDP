package com.nv.sbeans;

import org.springframework.stereotype.Component;

@Component("bDart")
public final class Bluedart implements Courier{

	public String deliver(int orderId) {
		
		return orderId+" Given to BlueDart";
		
		
		
	}

}
