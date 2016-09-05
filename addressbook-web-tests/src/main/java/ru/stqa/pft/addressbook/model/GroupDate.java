package ru.stqa.pft.addressbook.model;

public class GroupDate {
    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private final String name;
    private final String header;
    private final String footer;

    @Override
    public String toString() {
        return "GroupDate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupDate groupDate = (GroupDate) o;

        if (id != groupDate.id) return false;
        return name != null ? name.equals(groupDate.name) : groupDate.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public GroupDate(String name, String header, String footer) {
        this.id = 0;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public GroupDate(int id, String name, String header, String footer) {
        this.id = id;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

}
