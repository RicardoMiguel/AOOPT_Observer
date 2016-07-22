package com;

import java.util.Currency;
import java.util.Observable;

/**
 * Created by Ricardo on 17/05/2016.
 */
public class ExchangeRatio extends Observable{
    Currency currency;
    //value of 1 eur to dynamic currency;
    float value;

    public ExchangeRatio(Currency currency, float value){
        this.currency = currency;
        this.value = value;
    }

    public void changeValue(float value){
        this.value = value;
        setChanged();
        notifyObservers(value);
    }
}
