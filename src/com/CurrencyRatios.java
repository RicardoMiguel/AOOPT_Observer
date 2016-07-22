package com;

import java.util.HashMap;

/**
 * Created by Ricardo on 17/05/2016.
 */
public class CurrencyRatios extends HashMap<String,ExchangeRatio> {
    private static CurrencyRatios currencyRatios;
    private CurrencyRatios(){

    }

    public static CurrencyRatios getInstance(){
        if(currencyRatios == null){
            currencyRatios = new CurrencyRatios();
        }
        return currencyRatios;
    }

}
