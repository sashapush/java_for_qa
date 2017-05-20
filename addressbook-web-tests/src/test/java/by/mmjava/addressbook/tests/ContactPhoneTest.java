package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import by.mmjava.addressbook.model.Contacts;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

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
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomeNumber(),contact.getMobileNumber(),contact.getWorkNumber(),contact.getSecondaryPhone())   //4 номера превращаем в поток
                .stream().filter((s -> !s.equals("")))    //фильтруем пустые строки в потоке (убераем их из потокА)
                .map(ContactPhoneTest::cleaned) // применяем на поток функцию cleaned
                .collect(Collectors.joining("\n")); //клеим строки потока
    }

    public static String cleaned (String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]","").replaceAll("/+","");
    }

}
