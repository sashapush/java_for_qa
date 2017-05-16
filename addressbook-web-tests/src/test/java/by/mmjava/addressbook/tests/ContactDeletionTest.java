package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by User on 4/24/2017.
 */
public class ContactDeletionTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().Home();
        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().contactCreation(new ContactData("pre", null, "pre", "nick", "title", "company name", "address 1", "12345", "67894", "54577", "11", "tests@tests.com", "test2@tests.com", "test3@tests.com", "http://tests.com", "address 1\naddress 2", "1992", "2222", "test22","secondary address", "secondary home", "secondary notes"));
        }
        app.goTo().Home();
    }
    @Test
    public void testContactDeletion()
    {
        app.goTo().Home();
        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().contactCreation(new ContactData("new", null, "mew", "nick", "title", "company name", "address 1", "12345", "67894", "54577", "11", "tests@tests.com", "test2@tests.com", "test3@tests.com", "http://tests.com", "address 1\naddress 2", "1992", "2222", "test22","secondary address", "secondary home", "secondary notes"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.goTo().Home();
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().clickEditContact(before.size()-1);
        app.getContactHelper().deleteContact();
        app.goTo().Home();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() -1);
        before.remove(before.size()-1);
        Assert.assertEquals(before,after);

    }
}
