package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import by.mmjava.addressbook.model.Contacts;
import by.mmjava.addressbook.model.GroupData;
import by.mmjava.addressbook.model.Groups;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions ()
    {
        if ( app.db().groups().size()==0){
            app.group().create(new GroupData().withName("pre").withHeader("condition"));
        }
    }

    @DataProvider
    public Iterator<Object[]> validContactsFromXML() throws IOException { // итератор массивов объектов
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml"))); // завернули обычный ридер вБуферед ридер
        String xml = "";
        String line = reader.readLine();
        while (line != null){
            xml +=line;
            line = reader.readLine();
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        List<ContactData> groups = (List<ContactData>)xstream.fromXML(xml);
        return groups.stream().map((g -> new Object[] {g} )).collect(Collectors.toList()).iterator();
    }
    @DataProvider
    public Iterator<Object[]> validContactsFromJSON() throws IOException { // итератор массивов объектов
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json"))); // завернули обычный ридер вБуферед ридер
        String json = "";
        String line = reader.readLine();
        while (line != null){
            json +=line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());  //List <GroupData>.class
        return contacts.stream().map((g -> new Object[] {g} )).collect(Collectors.toList()).iterator();
    }
    @Test //(dataProvider = "validContactsFromJSON")
    public void testContactCreation( ) {
        Groups groups = app.db().groups();
        app.goTo().Home();
        Contacts before = app.db().contacts();
        File photo = new File("src/test/resources/boobs.jpg");
        ContactData contact = new ContactData()
             .withFirstname("test2").withLastname("test last name").withEmail("email@test.com").inGroup(groups.iterator().next()).withBirthYear("1992")
                .withAnniversaryYear("2200").withPhoto(photo);
        app.contact().create(contact);
        Contacts shmafter = before.withAdded(contact);
        Contacts after = app.db().contacts();
        assertThat(after.size(),equalToObject( before.size() + 1));
        //присвоение новому контакту корректного идентификатора: берём коллекцию, которая содержит группу с уже известными идентификаторами(афтер)
        //превращаём её в потом stream(); и в потоке ищем максимальный элемент при помощи компаратора.(mapToInt) - превращение потока объектов в поток чисел. ф-ия принимает на вход группу и выдает её ид
        //вызываем фию макс для нахождения максимума и преобразуем в целое число(getasint);
        //assertThat(after, equalTo(before));
        assertThat(after.size(),equalToObject( before.size() + 1));
        //assertThat(after, equalTo(before.withAdded(contact)));
        assertThat(after, equalToObject(
        before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));
    }

    @Test (enabled = false)
    public void testCurrentDir (){
        File currentDir = new File (".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/boobs.jpg") ;
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}
