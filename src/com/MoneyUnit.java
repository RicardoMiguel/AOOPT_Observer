package com;

import java.util.Currency;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Ricardo on 17/05/2016.
 */
public class MoneyUnit implements Observer {
    float eurValue;
    float value;
    Currency currency;

    MoneyUnit( Currency currency, float eurValue){
        this.eurValue = eurValue;
        this.currency = currency;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Float && o instanceof ExchangeRatio && ((ExchangeRatio) o).currency == currency){
            value = eurValue * (Float)arg;
        }
    }
}
