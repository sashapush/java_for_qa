package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() {
        gotoAddNewContact();
        //to do - send photo
        addContactData(new ContactData("alex", "middle", "last", "nick", "title", "company name", "address 1", "12345", "67894", "54564", "11", "tests@tests.com", "test2@tests.com", "test3@tests.com", "http://tests.com", "address 1\naddress 2", "1992", "2222", "secondary address", "secondary home", "secondary notes"));
        submitContactData();
        viewCreatedContactData();
        wd.findElement(By.xpath("//tr[@class='odd']/td[7]/a/img")).click();
    }

}
