package postOffice;

import postOffice.person.Recipient;
import postOffice.person.Sender;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Parcel {
    private Sender sender;
    private Recipient recipient;
    private int weight;
    private boolean priority;

    private Status status = Status.CREATED;
    private double price;

    public void setStatus(Status status) {
        this.status = status;
    }


    private List<Sender> senders = new LinkedList<>();
    private List<Recipient> recipients = new LinkedList<>();
    private Sender[] peopleArray = {new Sender("Maria", "Gorna"), new Sender("Jan", "Kowalski"),
            new Sender("Katarzyna", "Nowak"), new Sender("Jerzy", "Gorski"),
            new Sender("Bartlomiej", "Blaszka")};


    public Parcel(Sender sender, Recipient recipient, int weight) {

        if (weight < 0 || weight > 100000) {
            System.out.println("Podana waga jest nieprawidłowa");
            return;
        }
        if (!sender.getName().matches("^[A-Z][a-z]+") || !sender.getSurname().matches("^[A-Z][a-z]+")) {
            System.out.println("Podano niepoprawne dane Nadawcy");
            return;
        }

        if (!recipient.getName().matches("^[A-Z][a-z]+") || !recipient.getSurname().matches("^[A-Z][a-z]+")) {
            System.out.println("Podano niepoprawne dane Odbiorcy");
            return;
        }

        this.sender = sender;
        this.recipient = recipient;
        this.weight = weight;

    }

    public Parcel() {
        Random r = new Random();
        int r1 = r.nextInt(peopleArray.length);
        int r2 = r.nextInt(peopleArray.length);

        while (r1 == r2) {
            r2 = r.nextInt(peopleArray.length);
        }

        sender = new Sender(peopleArray[r1].getName(),
                peopleArray[r1].getSurname());

        recipient = new Recipient(peopleArray[r2].getName(),
                peopleArray[r2].getSurname());

        weight = r.nextInt(100001);
        priority = r.nextBoolean();
    }

    public int getWeight() {
        return weight;
    }

    public boolean isPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public double setPrice() {
        int parcelWeight = getWeight();
        boolean parcelPriority = isPriority();
        if (parcelWeight <= 500) {
            if (parcelPriority) {
                this.price = 5.5;
                return 5.5;
            }
            this.price = 5;
            return 5;
        }
        if (parcelWeight <= 1000) {
            if (parcelPriority) {
                this.price = 11;
                return 11;

            }
            this.price = 10;
            return 10;
        }
        if (parcelWeight <= 2000) {
            if (parcelPriority) {
                this.price = 13.2;
                return 13.2;
            }
            this.price = 12;
            return 12;
        }
        if (parcelPriority) {
            this.price = Math.round(((12 + (parcelWeight - 2000.0) / 1000) * 1.1));
            return Math.round(((12 + (parcelWeight - 2000.0) / 1000) * 1.1));
        }
        this.price = Math.round((12 + (parcelWeight - 2000.0) / 1000));
        return Math.round((12 + (parcelWeight - 2000.0) / 1000));
    }

    public Parcel(Sender sender, Recipient recipient, int weight, boolean priority) {

        if (weight < 0 || weight > 100000) {
            System.out.println("Podana waga jest nieprawidłowa");
            return;
        }
        if (!sender.getName().matches("^[A-Z][a-z]+") || !sender.getSurname().matches("^[A-Z][a-z]+")) {
            System.out.println("Podano niepoprawne dane Nadawcy");
            return;
        }

        if (!recipient.getName().matches("^[A-Z][a-z]+") || !recipient.getSurname().matches("^[A-Z][a-z]+")) {
            System.out.println("Podano niepoprawne dane Odbiorcy");
            return;
        }
        this.sender = sender;
        this.recipient = recipient;
        this.weight = weight;
        this.priority = priority;

    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "" + sender +
                recipient +
                "weight=" + weight +
                ", priority=" + priority;
    }


}
    /*Przygotuj również metodę pozwalającą wyliczyć i zwrócić cenę paczki, która zostanie wyliczona na podstawie jej parametrów:
        paczka do 0.5 kg  kosztuje 5 zł
        do 1kg kosztuje 8zł
        do 2 kg kosztuje 12 zł
        powyżej 2kg doliczane jest 1 zł za każdy kilogram
        paczka kosztuje 10% drożej jeśli jest priorytetowa*/
