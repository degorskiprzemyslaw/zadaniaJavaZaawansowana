package postOffice.person;

public abstract class Person {

    protected String name;
    protected String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    //public abstract String getName();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    //public abstract String getSurname();


    public String getSurname() {
        return surname;
    }

    @Override
    public abstract String toString();
}
