package by.mmjava.addressbook.tests;
import by.mmjava.addressbook.model.ContactData;
import by.mmjava.addressbook.model.Contacts;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by User on 4/24/2017.
 */
public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().Home();
        if (app.db().contacts().size()==0){
            app.contact().create(new ContactData()
                    .withFirstname("test2").withLastname("test last name").withEmail("email@test.com"));
        }
        app.goTo().Home();
    }
    @Test //(enabled = false)
    public void testContactModification()
    {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("change").withMiddlename(modifiedContact.getMiddlename()).withLastname("change")
                .withEmail("changed@test.com").withAddress("address changed").withAddress1("Address 2").withHomeNumber(modifiedContact.getHomeNumber())
                .withMobileNumber(modifiedContact.getMobileNumber()).withWorkNumber(modifiedContact.getWorkNumber())
                .withAddress1(modifiedContact.getAddress2()).withEmail2(modifiedContact.getEmail2()).withEmail3(modifiedContact.getEmail3());
        app.contact().modify(contact);
        Contacts after = app.db().contacts();
        assertThat(after, equalToObject(before.withModified(modifiedContact,contact)));
        //assertThat(after, equalToObject(before.without(modifiedContact).withAdded(contact)));
    }


}
