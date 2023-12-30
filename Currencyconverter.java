/*
 * TASK4---->CurrencyConverter
 * Currency Selection: Allow the user to choose the base currency and the target currency.
   Currency Rates: Fetch real-time exchange rates from a reliable API.
   Amount Input: Take input from the user for the amount they want to convert.
   Currency Conversion: Convert the input amount from the base currency to the target currency using the fetched exchange rate.
   Display Result: Show the converted amount and the target currency symbol to the user.
 */

package Task4;
import java.util.Scanner;

public class Currencyconverter {
	private static double[][] exchangeRates = { // Replace these rates with actual rates fetched from an API
			  {1.0, 0.85, 110.03},   // USD to {USD, EUR, JPY}
	          {1.18, 1.0, 129.67},   // EUR to {USD, EUR, JPY}
	          {0.0091, 0.0077, 1.0} // JPY to {USD, EUR, JPY}
			};
	private static String[] currencies = {"USD", "EUR", "JPY"};
	public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Base currency:");
      displayCurrencies();
      System.out.println("Select Base Currency:");
      int baseCurrencyIndex = scanner.nextInt();
      System.out.println("Target currency:");
      displayCurrencies();
      System.out.println("Select Target currency:");
      int targetCurrencyIndex = scanner.nextInt();
      System.out.println("Enter the amount to convert:");
      double amountToConvert = scanner.nextDouble();
      double convertedAmount = convertCurrency(baseCurrencyIndex, targetCurrencyIndex, amountToConvert);
      String targetCurrency = currencies[targetCurrencyIndex];
      System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
      scanner.close();
      }
	private static double convertCurrency(int baseCurrencyIndex, int targetCurrencyIndex, double amountToConvert) {
      double rate = exchangeRates[baseCurrencyIndex][targetCurrencyIndex];
      return amountToConvert * rate;
      }
	private static void displayCurrencies() {
      for (int i = 0; i < currencies.length; i++) {
          System.out.println((i + 1) + ". " + currencies[i]);
      }
  }
}
