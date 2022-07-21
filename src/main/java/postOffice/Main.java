package postOffice;

import postOffice.person.Recipient;
import postOffice.person.Sender;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Parcel parcel = new Parcel(new Sender("Przemek", "Degorski"),
                new Recipient("Lukasz", "Pociej"), 56);
        System.out.println(parcel);
        Parcel parcel2 = new Parcel();
        Parcel parcel3 = new Parcel();
        Parcel parcel4 = new Parcel();
        Parcel parcel5 = new Parcel();
        Parcel parcel6 = new Parcel();
        System.out.println(parcel2);
        System.out.println(parcel3);
        System.out.println(parcel4);
        System.out.println(parcel5);
        System.out.println(parcel6);
        System.out.println(parcel2.setPrice());
        Parcel parcel7 = null;
        parcel7 = parcel;
        System.out.println(parcel7.setPrice());

        Parcel[] parcels1 = {new Parcel(), new Parcel(), new Parcel()};
        System.out.println(parcels1[0]);

        List<Parcel> parcels2 = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            parcels2.add(new Parcel());
        }
        double sum = 0;
        for (Parcel aParcel : parcels2) {
            System.out.println(aParcel);
            sum += aParcel.setPrice();
        }
        System.out.println(sum);

        PostOffice postOffice = new PostOffice();
        /*Parcel parcel10 = postOffice.createParcel();
        parcel10.setPrice();
        System.out.println(parcel10);
        System.out.println(parcel10.getPrice());
        postOffice.sendParcel(parcel10, parcel10.getPrice());
        System.out.println(parcel10.getStatus());*/

        /*Letter letter = postOffice.createLetter();
        letter.setPrice(letter.isPriority());
        System.out.println(letter);
        System.out.println(letter.getPrice());*/
        Letter[] letters = postOffice.getLetters();
        for (Letter aLetter : letters) {
            System.out.println(aLetter);
        }
        postOffice.sendLetter();
        postOffice.sendLetter();
        postOffice.sendLetter();

        for (Letter aLetter : letters) {
            System.out.println(aLetter);
        }




    }
}
