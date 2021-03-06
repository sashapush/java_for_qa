package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by User on 5/20/2017.
 */
public class ContactEmailsTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().Home();
        if (app.contact().all().size()==0){
            app.contact().create(new ContactData().withFirstname("test2").withLastname("test last name").withEmail("email@test.com").
                    withMobileNumber("111").withHomeNumber("222").withWorkNumber("333").withEmail2("email2@test.com").withEmail3("email3@test.com"));
        }
        app.goTo().Home();
    }
    @Test
    public void testContactEmails() {
        app.goTo().Home();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }
    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3())   //4 номера превращаем в поток
                .stream().filter((s -> !s.equals("")))    //фильтруем пустые строки в потоке (убераем их из потокА)
                .map(ContactPhoneTest::cleaned) // применяем на поток функцию cleaned
                .collect(Collectors.joining("\n")); //клеим строки потока
    }
}
