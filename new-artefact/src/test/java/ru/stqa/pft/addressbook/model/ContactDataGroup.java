package ru.stqa.pft.addressbook.model;

public class ContactDataGroup {
    private int id;
    private final String cName;
    private final String cMiddleName;
    private final String cLastName;
    private final String cNickName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContactDataGroup(String cName, String cMiddleName, String cLastName, String cNickName) {
        this.id = 0;
        this.cName = cName;
        this.cMiddleName = cMiddleName;
        this.cLastName = cLastName;
        this.cNickName = cNickName;
    }

    public ContactDataGroup(int id, String cName, String cMiddleName, String cLastName, String cNickName) {
        this.id = id;
        this.cName = cName;
        this.cMiddleName = cMiddleName;
        this.cLastName = cLastName;
        this.cNickName = cNickName;
    }

    public String getcName() {
        return cName;
    }

    public String getcMiddleName() {
        return cMiddleName;
    }

    public String getcLastName() {
        return cLastName;
    }

    public String getcNickName() {
        return cNickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactDataGroup that = (ContactDataGroup) o;

        return cName != null ? cName.equals(that.cName) : that.cName == null;
    }

    @Override
    public int hashCode() {
        return cName != null ? cName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ContactDataGroup{" +
                "id=" + id +
                ", Name='" + cName + '\'' +
                '}';
    }
}
