package Service;

import model.Currency;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CurrencyService {
	public void addCurrency(ArrayList<Currency> currencyList, double exchangeRate, String name) {
		if (currencyList == null)
			currencyList = new ArrayList<>();
		currencyList.add(new Currency(name, exchangeRate));
	}

	public BigDecimal exchangeCurrency(ArrayList<Currency> currencyList, String playerCurrencyName, String teamCurrencyName,
									   BigDecimal budget) {
		String currencyNames = teamCurrencyName + "-" + playerCurrencyName;
		for (Currency currency : currencyList) {
			if (currency.getName().equals(currencyNames)) {
				budget = BigDecimal.valueOf(budget.doubleValue() * currency.getExchangeRate().doubleValue());
				break;
			}
		}
		return budget;
	}
}
