package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import by.mmjava.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by User on 6/18/2017.
 */
public class ContactRemoveFromGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().Home();
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData().withFirstname("test2").withLastname("test last name").withEmail("email@test.com"));
        }
        app.goTo().Home();
        //check if there are contacts with assigned group >1
        //add contact add to group
    }

    @Test
    public void testContactRemoveFromGroup() {
        app.goTo().Home();
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        app.contact().getGroupsAll();
        app.contact().contactRemoveFromGroup();
        }
    }
