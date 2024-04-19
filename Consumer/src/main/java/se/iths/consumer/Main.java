package se.iths.consumer;

import se.iths.service.Currency;
import se.iths.service.CurrencyName;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ServiceLoader<Currency> loader = ServiceLoader.load(Currency.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Currency Converter\n");
        String choice;

        loop:
        while (true) {
            printMenu(loader);
            choice = scanner.nextLine();
            while (checkIfCurrencyExists(loader, choice)) {
                if (choice.equalsIgnoreCase("exit")) break loop;

                System.out.println("Incorrect currency name. Try again.");
                choice = scanner.nextLine();
            }

            convertMoney(scanner, loader, choice);
        }
    }

    private static boolean checkIfCurrencyExists(ServiceLoader<Currency> loader, String choice) {
        for (Currency currency : loader) {
            var annotation = currency.getClass().getAnnotation(CurrencyName.class).value();
            if (annotation.equalsIgnoreCase(choice)) return false;
        }
        return true;
    }

    private static void convertMoney(Scanner scanner, ServiceLoader<Currency> loader, String toCurrency) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        CurrencyAndValue toConvert = getCurrencyAndValue(loader,scanner);
        for (Currency currency : loader) {
            var annotation = currency.getClass().getAnnotation(CurrencyName.class).value();
            if (annotation.equalsIgnoreCase(toCurrency)) {
                var method = currency.getClass().getMethod("convertCurrency", String.class, Double.class);
                var result = method.invoke(currency, toConvert.name(), toConvert.amount());
                System.out.println(toConvert.amount() + " " + toConvert.name() + " is " + result + " " + toCurrency);
                return;
            }
        }
    }

    private static CurrencyAndValue getCurrencyAndValue(ServiceLoader<Currency> loader, Scanner scanner) {
        String choice;
        System.out.println("Enter currency which you want to convert from: ");
        choice = scanner.nextLine();
        while (checkIfCurrencyExists(loader, choice)) {
            System.out.println("Incorrect currency name. Try again.");
            choice = scanner.nextLine();
        }
        System.out.println("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        return new CurrencyAndValue(choice, amount);
    }

    private static void printMenu(ServiceLoader<Currency> loader) {
        System.out.println("To which currency do you want to convert?");
        for (Currency currency : loader) {
            System.out.println(currency.getClass().getAnnotation(CurrencyName.class).value());
        }
        System.out.println("Exit");
    }

    private record CurrencyAndValue(String name, double amount) {
    }
}
