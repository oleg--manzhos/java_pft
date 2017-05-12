package ru.stqa.pft.addressbook.model;

public class ContactDataGroup {

    private int id = Integer.MAX_VALUE;
    private String cName;
    private String cMiddleName;
    private String cLastName;
    private String cNickName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ContactDataGroup withName(String cName) {
        this.cName = cName;
        return this;
    }

    public ContactDataGroup withMiddleName(String cMiddleName) {
        this.cMiddleName = cMiddleName;
        return this;
    }

    public ContactDataGroup withLastName(String cLastName) {
        this.cLastName = cLastName;
        return this;
    }

    public ContactDataGroup withNickName(String cNickName) {
        this.cNickName = cNickName;
        return this;
    }

    public ContactDataGroup withId (int id){
        this.id = id;
        return this;
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
