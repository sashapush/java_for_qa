package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import by.mmjava.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static by.mmjava.addressbook.tests.TestBase.app;

/**
 * Created by User on 6/6/2017.
 */
public class ContactAddToGroupTest extends TestBase {
    @BeforeMethod


    @Test
    public void testContactAddToGroup(){
        app.goTo().Home();
        Contacts before = app.db().contacts();  // получен список контактов
        ContactData modifiedContact = before.iterator().next();
        app.contact().addToGroup(modifiedContact);
        }
}
