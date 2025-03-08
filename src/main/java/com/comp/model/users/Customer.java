package com.comp.model.users;
public class Customer {

    private int id;
    private String name;
    private String address;
    private String mail;

    public Customer() {}
    public Customer(String name, String address, String mail) {
        this.name = name;
        this.address = address;
        this.mail = mail;
    }

    public int getId() {
        return id;
    } public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    } public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    } public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    } public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "\nName: " + name + "(ID: " + id + ")" +
                "\nAddress: " + address +
                "\nMail: " + mail;
    }
}
