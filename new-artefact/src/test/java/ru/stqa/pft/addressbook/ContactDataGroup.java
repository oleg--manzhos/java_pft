package ru.stqa.pft.addressbook;

public class ContactDataGroup {
    private final String cName;
    private final String cMiddleName;
    private final String cLastName;
    private final String cNickName;

    public ContactDataGroup(String cName, String cMiddleName, String cLastName, String cNickName) {
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
}
