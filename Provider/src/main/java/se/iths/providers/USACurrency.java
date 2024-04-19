package se.iths.providers;

import se.iths.service.Currency;
import se.iths.service.CurrencyName;

@CurrencyName("USD")
public class USACurrency implements Currency {
    @Override
    public Double convertCurrency(String from, Double amount) {
        if (from.equalsIgnoreCase("Sek"))
            return amount * 0.091;
        if (from.equalsIgnoreCase("Yen"))
            return amount*0.0065;
        if (from.equalsIgnoreCase("Euro"))
            return amount * 1.06;
        if (from.equalsIgnoreCase("USD")) {
            return amount;
        }
        return 0.0;
    }
}
