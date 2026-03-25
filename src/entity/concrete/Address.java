package entity.concrete;

import java.util.Objects;

public class Address {
    private String city;
    private Integer postalCode;
    private String street;

    public  Address() {}

    public Address(String city, Integer postalCode, String street) {
        this.setCity(city);
        this.setStreet(street);
        this.setPostalCode(postalCode);
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return " City: " + city + " Street: " + street + " Postal Code: " + postalCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != getClass())
            return false;
        Address address = (Address) obj;
        return address.postalCode.equals(postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postalCode);
    }
}
