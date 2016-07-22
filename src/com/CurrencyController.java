package com;


import com.sun.istack.internal.NotNull;

import java.util.Currency;

/**
 * Created by Ricardo on 17/05/2016.
 */
public class CurrencyController {
    static final Currency plnC = Currency.getInstance("PLN");
    static final Currency eurC = Currency.getInstance("EUR");
    static final Currency hufC = Currency.getInstance("HUF");
    static final Currency czkC = Currency.getInstance("CZK");

    public void initializeRatios(){

        CurrencyRatios instance = CurrencyRatios.getInstance();
        instance.put(plnC.toString(), new ExchangeRatio(plnC, 4.39f));
        instance.put(eurC.toString(), new ExchangeRatio(eurC, 1f));
        instance.put(hufC.toString(), new ExchangeRatio(hufC, 315.64f));
        instance.put(czkC.toString(), new ExchangeRatio(czkC, 27.04f));
    }

    public void add(@NotNull MoneyBag moneyBag, @NotNull MoneyUnit... moneyUnits){
        if(moneyUnits.length != 0) {
            CurrencyRatios instance = CurrencyRatios.getInstance();
            for (MoneyUnit moneyUnit : moneyUnits) {
                ExchangeRatio exchangeRatio = instance.get(moneyUnit.currency.toString());
                exchangeRatio.addObserver(moneyUnit);
                moneyUnit.update(exchangeRatio, exchangeRatio.value);
                moneyBag.add(moneyUnit);
            }
        }
    }

    public void changeRatio(@NotNull Currency currency, float value){
        CurrencyRatios instance = CurrencyRatios.getInstance();
        ExchangeRatio exchangeRatio = instance.get(currency.toString());
        exchangeRatio.changeValue(value);
    }
}
