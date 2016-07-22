package com;

public class Main {

    public static void main(String[] args) {

        CurrencyController controller = new CurrencyController();
        controller.initializeRatios();

        MoneyBag moneyBag = new MoneyBag();

        controller.add(moneyBag, new MoneyUnit(CurrencyController.plnC, 20),
                new MoneyUnit(CurrencyController.plnC, 50.6f),
                new MoneyUnit(CurrencyController.hufC, 12000.6f),
                new MoneyUnit(CurrencyController.hufC, 500f),
                new MoneyUnit(CurrencyController.czkC, 2000f),
                new MoneyUnit(CurrencyController.eurC, 1f));

        System.out.println(moneyBag.getTotalAmount(CurrencyController.eurC));
        controller.changeRatio(CurrencyController.eurC, 2);
        System.out.println(moneyBag.getTotalAmount(CurrencyController.eurC));

        System.out.println(moneyBag.getTotalAmount(CurrencyController.hufC));
        controller.changeRatio(CurrencyController.hufC, 400);
        System.out.println(moneyBag.getTotalAmount(CurrencyController.hufC));
    }
}
