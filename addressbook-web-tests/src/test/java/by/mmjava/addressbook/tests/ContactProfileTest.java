package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by User on 5/21/2017.
 */
public class ContactProfileTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().Home();
        if (app.contact().all().size()==0){
            app.contact().create(new ContactData().withFirstname("test2").withLastname("test last name").
                    withEmail("email@test.com").withEmail2("email2@test.com").withEmail3("email3@test.com").withMobileNumber("111").
                    withHomeNumber("222").withWorkNumber("333").withAddress("address 1"));
        }
        app.goTo().Home();
    }
    @Test
    public void testContactProfile() {
        app.goTo().Home();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromContactPage = app.contact().infoFromContactPage(contact);
        ContactData contactInfoFromEditForm = app.contact().gluedInfoFromEditForm(contact);
        assertThat(contactInfoFromEditForm.getAllContactData(), equalTo((contactInfoFromContactPage.getAllContactData())));
    }

    private String mergeProfileData(ContactData contact) {
        return Arrays.asList(contact.getAllContactData())   //4 номера превращаем в поток
                .stream().filter((s -> !s.equals("")))    //фильтруем пустые строки в потоке (убераем их из потокА)
                .map(ContactProfileTest::cleaned) // применяем на поток функцию cleaned
                .collect(Collectors.joining("\n")); //клеим строки потока
    }

    public static String cleaned (String phone){
        return phone.replaceAll("\\s","");
                //.replaceAll("((M:)+)","")
                //.replaceAll("((H:)+)","").replaceAll("((W:)+)","");
    }
}
