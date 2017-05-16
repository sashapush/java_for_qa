package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Created by User on 4/24/2017.
 */
public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().Home();
        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().contactCreation(new ContactData("pre", null, "pre", "nick", "title", "company name", "address 1", "12345", "67894", "54577", "11", "tests@tests.com", "test2@tests.com", "test3@tests.com", "http://tests.com", "address 1\naddress 2", "1992", "2222", "test22","secondary address", "secondary home", "secondary notes"));
        }
        app.goTo().Home();
    }
    @Test //(enabled = false)
    public void testContactModification()
    {
List<ContactData> before = app.getContactHelper().getContactList();
        int index = before.size()-1;
        ContactData contact = new ContactData(before.get(index).getId(),"test","modified","alex",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
        app.getContactHelper().modifyContact(index, contact);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super  ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
        }


}
