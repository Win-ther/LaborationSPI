package se.iths.providers;

import se.iths.service.Currency;
import se.iths.service.CurrencyName;

@CurrencyName("Sek")
public class SwedishCurrency implements Currency {
    @Override
    public Double convertCurrency(String from, Double amount) {
        if (from.equalsIgnoreCase("Euro"))
            return amount*11.66;
        if (from.equalsIgnoreCase("Yen"))
            return amount*0.071;
        if (from.equalsIgnoreCase("USD"))
            return amount*10.97;
        if (from.equalsIgnoreCase("sek")) {
            return amount;
        }
        return 0.0;
    }
}
