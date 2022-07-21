package postOffice.person;

import postOffice.person.Person;

public class Recipient extends Person {


    public Recipient(String name, String surname) {
        super(name, surname);
    }






    @Override
    public String toString() {
        return "Recipient's name: " +
                name + ", " +
                "Recipient's surname: " + surname + ", ";
    }
}
