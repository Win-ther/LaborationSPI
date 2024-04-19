import se.iths.providers.JapaneseCurrency;
import se.iths.providers.EuroCurrency;
import se.iths.providers.SwedishCurrency;
import se.iths.providers.USACurrency;
import se.iths.service.Currency;

module se.iths.provider {
    requires se.iths.service;
    opens se.iths.providers to se.iths.consumer;
    provides Currency with SwedishCurrency, JapaneseCurrency, EuroCurrency, USACurrency;
}