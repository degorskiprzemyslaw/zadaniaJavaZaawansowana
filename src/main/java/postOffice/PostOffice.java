package postOffice;

import postOffice.person.Address;
import postOffice.person.Recipient;
import postOffice.person.Sender;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class PostOffice {
    private Parcel parcel;
    private static double takings;
    int listCounter;
    private Letter[] letters = new Letter[10];


    public void sendParcel(Parcel parcel, double price) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wysłanie paczki kosztuje: " + parcel.getPrice() + " zł.\nWprowadź kwotę do zapłaty: ");
        double money = scanner.nextDouble();
        if (price > money) {
            System.out.println("Nie zapłacono wystarczającej kwoty.");
            return;
        } else if (price == money) {
            System.out.println("Udało się wysłać paczkę");
            parcel.setStatus(Status.SENT);
            takings += price;
        } else {
            System.out.println("Udało się wysłać paczkę. Zwrot: " + (money - price));
            parcel.setStatus(Status.SENT);
            takings += price;
        }
    }

    public Parcel createParcel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imię nadawcy");
        String senderName = scanner.nextLine();
        System.out.println("Podaj nazwisko nadawcy");
        String senderSurname = scanner.nextLine();
        System.out.println("Podaj imię odbiorcy");
        String recipientName = scanner.nextLine();
        System.out.println("Podaj nazwisko odbiorcy");
        String recipientSurname = scanner.nextLine();
        System.out.println("Podaj wagę paczki");
        int weight = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Czy ma być priorytetowa? tak/nie");
        String priorityValue = scanner.nextLine();
        boolean priority;
        if (priorityValue.equalsIgnoreCase("tak")) {
            priority = true;
        } else {
            priority = false;
        }
        return new Parcel(new Sender(senderName, senderSurname), new Recipient(recipientName, recipientSurname), weight, priority);

    }

    public Letter createLetter() {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imię nadawcy");
        String senderName = scanner.nextLine();
        System.out.println("Podaj nazwisko nadawcy");
        String senderSurname = scanner.nextLine();
        Sender letterSender = new Sender(senderName, senderSurname);
        Address senderAddress = insertSenderAddressData();

        System.out.println("Podaj imię odbiorcy");
        String recipientName = scanner.nextLine();
        System.out.println("Podaj nazwisko odbiorcy");
        String recipientSurname = scanner.nextLine();
        Recipient letterRecipient = new Recipient(recipientName, recipientSurname);
        Address recipientAddress = insertRecipientAddressData();

        System.out.println("Czy list ma być priorytetowy? tak/nie");
        String priorityValue = scanner.nextLine();
        boolean priority;
        if (priorityValue.equalsIgnoreCase("tak")) {
            priority = true;
        } else {
            priority = false;
        }
        return new Letter(letterSender, letterRecipient, priority, senderAddress, recipientAddress);

    }

    private Address insertSenderAddressData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\tPodaj adres nadawcy");
        System.out.println("Podaj ulicę nadawcy");
        String senderStreet = scanner.nextLine();
        System.out.println("Podaj numer domu nadawcy");
        String senderHouseNumber = scanner.nextLine();
        System.out.println("Podaj miasto nadawcy");
        String senderCityName = scanner.nextLine();
        System.out.println("Podaj kod pocztowy nadawcy");
        String senderZipCode = scanner.nextLine();
        System.out.println();

        return new Address(senderStreet, senderHouseNumber, senderCityName, senderZipCode);
    }

    private Address insertRecipientAddressData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\tPodaj adres odbiorcy");
        System.out.println("Podaj ulicę odbiorcy");
        String recipientStreet = scanner.nextLine();
        System.out.println("Podaj numer domu odbiorcy");
        String recipientHouseNumber = scanner.nextLine();
        System.out.println("Podaj miasto odbiorcy");
        String recipientCityName = scanner.nextLine();
        System.out.println("Podaj kod pocztowy odbiorcy");
        String recipientZipCode = scanner.nextLine();
        System.out.println();

        return new Address(recipientStreet, recipientHouseNumber, recipientCityName, recipientZipCode);
    }

    public Letter[] getLetters() {
        return letters;
    }

    public void sendLetter() {
        listCounter++;
        if (listCounter == letters.length) {
            letters = Arrays.copyOf(letters, letters.length * 2);
        }
        Scanner scanner = new Scanner(System.in);
        Letter letter = createLetter();
        double price = letter.setPrice(letter.isPriority());

        System.out.println("Wysłanie listu kosztuje: " + price + " zł.\nWprowadź kwotę do zapłaty: ");
        double money = scanner.nextDouble();
        if (price > money) {
            System.out.println("Nie zapłacono wystarczającej kwoty.");
            return;
        } else if (price == money) {
            System.out.println("Udało się wysłać list");
            letter.setStatus(Status.SENT);
            takings += price;
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == null) {
                    letters[i] = letter;
                    break;
                }

            }
        } else {
            System.out.println("Udało się wysłać list. Zwrot: " + (money - price));
            letter.setStatus(Status.SENT);
            takings += price;
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == null) {
                    letters[i] = letter;
                    break;
                }
            }
        }
    }

    public void sendPostman() {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != null) {
                letters[i].setStatus(Status.SENT);
                letters[i] = null;
            } else {
                break;
            }
        }
    }
}


