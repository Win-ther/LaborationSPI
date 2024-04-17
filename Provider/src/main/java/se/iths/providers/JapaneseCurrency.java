package se.iths.providers;

import se.iths.service.Currency;
import se.iths.service.CurrencyName;

@CurrencyName("Yen")
public class JapaneseCurrency implements Currency {
    @Override
    public Double convertCurrency(String from, Double amount) {
        if (from.equalsIgnoreCase("Euro"))
            return amount*164.57;
        if (from.equalsIgnoreCase("Sek"))
            return amount*14.10;
        if (from.equalsIgnoreCase("Yen"))
            return amount;
        return 0.0;
    }
}
