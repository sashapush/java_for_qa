package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

/**
 * Created by User on 4/24/2017.
 */
public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification()
    {
        app.getNavigationHelper().gotoHome();
        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().contactCreation();
        }
        app.getNavigationHelper().gotoHome();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size()-5);
        app.getContactHelper().clickEditContact(before.size()-5);
        ContactData contact = new ContactData(before.get(before.size()-5).getId(),"modified","modified","alex",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
        app.getContactHelper().addContactData(contact,false);
        app.getContactHelper().submitUpdatedContactData();
        app.getNavigationHelper().gotoHome();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());
        before.remove(before.size()-5);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }

}
