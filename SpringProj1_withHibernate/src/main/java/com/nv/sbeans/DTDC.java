package com.nv.sbeans;

import org.springframework.stereotype.Component;

@Component("dtdc")
public final class DTDC implements Courier {

	public String deliver(int orderId) {

		return orderId + " given to DTDC Courier";

	}

}
