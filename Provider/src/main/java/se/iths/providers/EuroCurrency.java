package se.iths.providers;

import se.iths.service.Currency;
import se.iths.service.CurrencyName;

@CurrencyName("Euro")
public class EuroCurrency implements Currency {
    @Override
    public Double convertCurrency(String from, Double amount) {
        if (from.equalsIgnoreCase("Sek"))
            return amount*0.086;
        if (from.equalsIgnoreCase("Yen"))
            return amount*0.0061;
        if (from.equalsIgnoreCase("Euro"))
            return amount;
        return 0.0;
    }
}
