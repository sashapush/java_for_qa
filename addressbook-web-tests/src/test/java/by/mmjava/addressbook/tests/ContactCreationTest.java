package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoAddNewContact();
        //to do - send photo
        app.getContactHelper().addContactData(new ContactData("alex", "middle", "last", "nick", "title", "company name", "address 1", "12345", "67894", "54577", "11", "tests@tests.com", "test2@tests.com", "test3@tests.com", "http://tests.com", "address 1\naddress 2", "1992", "2222", "test1","secondary address", "secondary home", "secondary notes"),true);
        app.getContactHelper().submitContactData();
        app.getContactHelper().viewCreatedContactData();
        }

}
