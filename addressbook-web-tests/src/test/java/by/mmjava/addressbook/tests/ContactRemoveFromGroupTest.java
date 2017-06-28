package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import by.mmjava.addressbook.model.Contacts;
import by.mmjava.addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
        Contacts before = app.db().contacts();  // получен список контактов
        //ContactData modifiedContact = before.iterator().next();
        Iterator<ContactData> ig = before.iterator();
        //for (int i = 0; i < app.db().contacts().size(); i++) {
        for  (ContactData groups : before) {
            ContactData modifiedContact = ig.next();
            Set<GroupData> contactGroups = modifiedContact.getGroups();
            if (contactGroups.size() > 0) {
                app.contact().contactRemoveFromGroup(modifiedContact);
                app.goTo().Home();
                Contacts after = app.db().contacts();
                assertThat(after, equalTo(before.without(modifiedContact).withAdded(modifiedContact)));
                break;
                } else {
                return;
            }
        }
    }
}
