package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by omanzhos on 5/18/2017.
 */
public class Contacts extends ForwardingSet<ContactDataGroup> {

    private Set<ContactDataGroup> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<ContactDataGroup>(contacts.delegate);
    }

    public Contacts() {
        this.delegate = new HashSet<ContactDataGroup>();
    }

    @Override
    protected Set<ContactDataGroup> delegate() {
        return delegate;
    }

    public Contacts withAdded (ContactDataGroup contact){
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }

    public Contacts withoutAdded (ContactDataGroup contact){
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }
}
