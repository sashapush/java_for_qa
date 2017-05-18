package by.mmjava.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 5/18/2017.
 */
public class Contacts extends ForwardingSet<ContactData> {

    private Set<ContactData> delegate;

    public Contacts (Contacts contacts) {
        this.delegate = new HashSet<ContactData>(contacts.delegate);
    }
    public Contacts() {
        this.delegate = new HashSet<ContactData>();
    }
    @Override
    protected Set<ContactData> delegate() {
        return delegate;
    }

    public Contacts withAdded(ContactData contact){   //метод делает копию
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }
    public Contacts without(ContactData contact){
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }
    public Contacts withModified(ContactData contact, ContactData modifiedContact){
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        contacts.add(modifiedContact);
        return contacts;
    }
}

