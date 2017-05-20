package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import by.mmjava.addressbook.model.Contacts;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by User on 5/20/2017.
 */
public class ContactPhoneTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().Home();
        if (app.contact().all().size()==0){
            app.contact().create(new ContactData().withFirstname("test2").withLastname("test last name").withEmail("email@test.com").withMobileNumber("111").withHomeNumber("222").withWorkNumber("333"));
        }
        app.goTo().Home();
    }
    @Test
    public void testContactPhones() {
        app.goTo().Home();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getHomeNumber(), equalTo(cleaned(contactInfoFromEditForm.getHomeNumber())));
        assertThat(contact.getMobileNumber(), equalTo(cleaned(contactInfoFromEditForm.getMobileNumber())));
        assertThat(contact.getWorkNumber(), equalTo(cleaned(contactInfoFromEditForm.getWorkNumber())));
    }
public String cleaned (String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]","").replaceAll("/+","");
}

}
