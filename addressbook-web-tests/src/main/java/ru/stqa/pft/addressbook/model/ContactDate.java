package ru.stqa.pft.addressbook.model;

public class ContactDate {
    private final String firstname;
    private final String lastname;
    private final String email;
    private String group;
    private int id;

    public ContactDate(String firstname, String lastname, String email, String group, int id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.group = group;
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }
}
