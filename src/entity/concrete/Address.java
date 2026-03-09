package entity.concrete;

import java.util.Objects;

public class Address {
    private String city;
    private Integer postalCode;
    private String street;

    public Address(String city, Integer postalCode, String street) {
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
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

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "City: " + city + "Street: " + street;
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
