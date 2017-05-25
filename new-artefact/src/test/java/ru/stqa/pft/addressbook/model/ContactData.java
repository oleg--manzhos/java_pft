package ru.stqa.pft.addressbook.model;

public class ContactData {

    private int id = Integer.MAX_VALUE;
    private String cName;
    private String cMiddleName;
    private String cLastName;
    private String cNickName;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String allPhones;

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

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

    public ContactData withName(String cName) {
        this.cName = cName;
        return this;
    }

    public ContactData withMiddleName(String cMiddleName) {
        this.cMiddleName = cMiddleName;
        return this;
    }

    public ContactData withLastName(String cLastName) {
        this.cLastName = cLastName;
        return this;
    }

    public ContactData withNickName(String cNickName) {
        this.cNickName = cNickName;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        return cName != null ? cName.equals(that.cName) : that.cName == null;
    }

    @Override
    public int hashCode() {
        return cName != null ? cName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", Name='" + cName + '\'' +
                '}';
    }
}