package com;

import java.util.ArrayList;
import java.util.Currency;

/**
 * Created by Ricardo on 17/05/2016.
 */
public class MoneyBag extends ArrayList<MoneyUnit> {
     public void add(MoneyUnit... moneyUnits){
         for(MoneyUnit moneyUnit : moneyUnits){
             add(moneyUnit);
         }
     }

    public String toString(){

        return "EUR total: "+ getTotalAmount();
    }

    public float getTotalAmount(){
        float total = 0;
        for(MoneyUnit moneyUnit : this){
            total += moneyUnit.eurValue;
        }
        return total;
    }

    public float getTotalAmount(Currency currency){
        float total = 0;
        for(MoneyUnit moneyUnit : this){
            if(moneyUnit.currency == currency) {
                total += moneyUnit.value;
            }
        }
        return total;
    }
}
