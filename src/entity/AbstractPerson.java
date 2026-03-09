package entity;

import entity.concrete.Address;

import java.util.Objects;

public abstract class AbstractPerson {
    private Long id;
    private String name;
    private Address address;
    private String phoneNumber;
    private String email;

    public AbstractPerson(Long id, String name, Address address, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        if (name == null)
            throw new IllegalArgumentException("Name argument cannot be null");
        if (name.isEmpty())
            throw new IllegalArgumentException("Name argument cannot be empty");
        this.name = name;
    }

    public void setAddress(Address address) {
        if (address == null)
            throw new IllegalArgumentException("Address argument cannot be null");
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null)
            throw new IllegalArgumentException("Phone number argument cannot be null");
        if (phoneNumber.isEmpty())
            throw new IllegalArgumentException("Phone number argument cannot be empty");
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        if (email == null)
            throw new IllegalArgumentException("Email number argument cannot be null");
        if (email.isEmpty())
            throw new IllegalArgumentException("Email number argument cannot be empty");
    }

    @Override
    public String toString() {
        return "Name: " + name
                + "Email: " + email
                + "Phone Number: " +phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if (obj == null || obj.getClass() != getClass())
            return false;
        AbstractPerson person = (AbstractPerson) obj;
        return person.id.equals(id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
