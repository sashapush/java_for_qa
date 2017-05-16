package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase{

    @Test //(enabled = false)
    public void testContactCreation() {
        app.goTo().Home();
        List<ContactData> before = app.contact().list();
        app.goTo().AddNewContact();
        //to do - send photo
        ContactData contact = new ContactData("new", null, "mew", "nick", "title", "company name", "address 1", "12345", "67894", "54577", "11", "tests@tests.com", "test2@tests.com", "test3@tests.com", "http://tests.com", "address 1\naddress 2", "1992", "2222", "test22","secondary address", "secondary home", "secondary notes");
        app.contact().create(contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);
        before.add(contact);
        Comparator<? super  ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }
}
