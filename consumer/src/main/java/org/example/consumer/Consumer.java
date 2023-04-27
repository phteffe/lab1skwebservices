package org.example.consumer;

import org.example.service.CurrencyExchange;
import org.example.service.annotation.Currency;

import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Consumer {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        boolean run = true;
        while (run){
            printMenu();

            switch (scanner.nextLine()){
                case "1" -> {
                    System.out.println("You have selected USD");
                    System.out.println("Enter the amount you want to exchange: ");
                    try {
                        convertToUsd(Double.parseDouble(scanner.nextLine()));
                        run = keepGoingOrQuit();
                    } catch (Exception e) {
                        System.out.println("Wrong input, try again.");
                    }
                }
                case "2" -> {
                    System.out.println("You have selected EUR");
                    System.out.println("Enter the amount you want to exchange: ");
                    try {
                        convertToEur(Double.parseDouble(scanner.nextLine()));
                        run = keepGoingOrQuit();
                    } catch (Exception e) {
                        System.out.println("Wrong input, try again.");
                    }
                }
                case "3" -> {
                    System.out.println("You have selected GBP");
                    System.out.println("Enter the amount you want to exchange: ");
                    try {
                        convertToGbp(Double.parseDouble(scanner.nextLine()));
                        run = keepGoingOrQuit();
                    } catch (Exception e) {
                        System.out.println("Wrong input, try again.");
                    }
                }
                case "0" -> {
                    System.out.println("Exiting");
                    System.exit(0);
                }
                default -> System.out.println("Wrong input, try again.");
            }
        }

    }
    private static boolean keepGoingOrQuit(){
        System.out.println("Do you want to make another exchange?(Y/N)");
        if (!scanner.nextLine().equalsIgnoreCase("Y"))
            return false;
        return true;
    }
    private static List<CurrencyExchange> getCurrencyConverter(String currency) {

        ServiceLoader<CurrencyExchange> currencyConverters = ServiceLoader.load(CurrencyExchange.class);

        return currencyConverters.stream()
                .filter(c -> c.type().isAnnotationPresent(Currency.class) &&
                        c.type().getAnnotation(Currency.class).value().equals(currency))
                .map(ServiceLoader.Provider::get)
                .toList();
    }

    private static void convertToUsd(double amount) {
        for (var converters : getCurrencyConverter("USD")) {
            System.out.println(amount + "SEK = " + converters.getCurrency(amount) + "USD");
        }
    }
    private static void convertToEur(double amount) {
        for (var converters : getCurrencyConverter("EUR")) {
            System.out.println(amount + "SEK = " + converters.getCurrency(amount) + "EUR");
        }
    }
    private static void convertToGbp(double amount) {
        for (var converters : getCurrencyConverter("GBP")) {
            System.out.println(amount + "SEK = " + converters.getCurrency(amount) + "GBP");
        }
    }

    private static void printMenu() {
        System.out.println("""
    Choose a Currency to convert from SEK
    1.USD
    2.EUR
    3.GBP
    0.EXIT PROGRAM
    				""");
    }
}
