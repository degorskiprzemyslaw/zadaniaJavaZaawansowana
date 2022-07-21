package postOffice.person;

public class Address {

    private String streetName;
    private String houseNumber;

    private String cityName;
    private String zipCode;

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", cityName='" + cityName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public Address(String streetName, String houseNumber, String cityName, String zipCode) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.cityName = cityName;
        this.zipCode = zipCode;
    }
}
