package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.*;

import java.util.List;

public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoAddNewContact();
        //to do - send photo
        ContactData contact = new ContactData(0,"alex", null, "last", "nick", "title", "company name", "address 1", "12345", "67894", "54577", "11", "tests@tests.com", "test2@tests.com", "test3@tests.com", "http://tests.com", "address 1\naddress 2", "1992", "2222", "test1","secondary address", "secondary home", "secondary notes");
        app.getContactHelper().addContactData(contact,true);
        //возможность оставлять дефолтовые значения полей ниже
        //app.getContactHelper().addContactData(new ContactData("alex","alex","alex",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null),true);
        app.getContactHelper().submitContactData();
        app.getContactHelper().viewCreatedContactData();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
        before.add(contact);
        }

}
