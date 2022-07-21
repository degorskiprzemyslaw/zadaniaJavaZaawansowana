package postOffice.person;

import postOffice.person.Person;

public class Sender extends Person {


    public Sender(String name, String surname) {
        super(name, surname);
    }





    @Override
    public String toString() {
        return "Sender's name: " +
                name + ", " +
                "Sender's surname: " + surname + ", ";
    }


}
