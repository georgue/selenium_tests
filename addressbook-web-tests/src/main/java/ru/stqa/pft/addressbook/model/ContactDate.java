package ru.stqa.pft.addressbook.model;

public class ContactDate {
    private final String firstname;
    private final String lastname;
    private final String email;
    private String group;
    private int id;

    public ContactDate(String firstname, String lastname, String email, String group) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.group = group;
        this.id = Integer.MAX_VALUE;
    }

    public int getId() {
        return id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactDate that = (ContactDate) o;

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactDate{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", id=" + id +
                '}';
    }
}
