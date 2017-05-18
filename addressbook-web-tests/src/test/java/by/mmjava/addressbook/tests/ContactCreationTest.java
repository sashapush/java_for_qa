package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import by.mmjava.addressbook.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{

    @Test //(enabled = false)
    public void testContactCreation() {
        app.goTo().Home();
        Contacts before = app.contact().all();
        //to do - send photo
        ContactData contact = new ContactData()
                .withFirstname("test2").withLastname("test last name").withEmail("email@test.com").withGroup("new").withBirthYear("1992").withAnniversaryYear("2200");
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(),equalToObject( before.size() + 1));
        //присвоение новому контакту корректного идентификатора: берём коллекцию, которая содержит группу с уже известными идентификаторами(афтер)
        //превращаём её в потом stream(); и в потоке ищем максимальный элемент при помощи компаратора.(mapToInt) - превращение потока объектов в поток чисел. ф-ия принимает на вход группу и выдает её ид
        //вызываем фию макс для нахождения максимума и преобразуем в целое число(getasint);
        assertThat(after, equalToObject(
                before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));
    }


}
