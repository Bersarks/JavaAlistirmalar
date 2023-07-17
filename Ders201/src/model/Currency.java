package model;

import java.math.BigDecimal;

public class Currency {
	private String name;
	private BigDecimal exchangeRate;

	public Currency(String name, double exchangeRate) {
		this.name = name;
		this.exchangeRate = BigDecimal.valueOf(exchangeRate);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
}
