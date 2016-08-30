# Observer exercise - MoneyUnit observing ExchangeRatio

Using the Java library interface Observer and class Observable (read about them in Java API Documentation) implement a following currency system:

A class MoneyBag contains a collection (list) of MoneyUnits. Each MoneyUnit is an amount of money in a specific currency (USD, PLN, EUR, GBP, ...). It has also a third field: value holding the value of this unit in Euro independently of the real unit currency.

In the system there is also a CurrencyRatios class containing a collection of ExchangeRatios for each used in the system currency (ex. for PLN - how many PLN one should pay for 1 EUR). ExchangeRatio objects can be stored in CurrencyRatios object in a HashMap<String,ExchangeRatio> for easier currency finding. This class can be implemented with the Singleton pattern.

When one currency exchange ratio changes, all MoneyUnit expressed in this currency should update their value fields (expressed always in EUR). To achieve this, make each MoneyUnit observing (by implementing the Observer interface and registering it to the correct ExchangeRatio object) one specific ExchangeRatio (which should inherit from the Observable class)

Create one or more MoneyBags filled with several MoneyUnits in different currencies. Change few exchange ratios and observe, how the money unit values react and stay up to date.


Hint:
1 Each method changing the exchange ratio should also call a setChanged() method (inherited from the Observable class) before the notifyObservers method (also inherited from the Observable class) is called.
2 Managing the observers (e.g. specifying which observer observes which observable - in other words: registering observers to the observable) should be done using methods inherited from the Observable class (addObserver, ...).