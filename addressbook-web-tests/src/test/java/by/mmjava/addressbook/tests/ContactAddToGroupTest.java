package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import by.mmjava.addressbook.model.Contacts;
import by.mmjava.addressbook.model.GroupData;
import by.mmjava.addressbook.model.Groups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static by.mmjava.addressbook.tests.TestBase.app;
import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by User on 6/6/2017.
 */
public class ContactAddToGroupTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().Home();
        if (app.db().contacts().size()==0){
            app.contact().create(new ContactData().withFirstname("test2").withLastname("test last name").withEmail("email@test.com"));
        }
        app.goTo().Home();
        app.goTo().GroupsPage();
        if ( app.db().groups().size()==0){
            app.group().create(new GroupData().withName("pre").withHeader("condition"));
        }
    }

    @Test
    public void testContactAddToGroup() {
        Set <GroupData> newContactGroups;
        Set <GroupData> contactGroups;
        app.goTo().Home();
        Contacts before = app.db().contacts();  // получен список контактов
        Iterator<ContactData> ig = before.iterator();     //итератор для правильного перебора коллекции в цикле
        for  (ContactData groups : before) {
            ContactData modifiedContact = ig.next();
            Set<GroupData> allGroups = app.db().groups();
            contactGroups = modifiedContact.getGroups();
            allGroups.removeAll(contactGroups);
            if (allGroups.size()>0){
                app.contact().contactAddToGroup(modifiedContact,allGroups);
                newContactGroups = modifiedContact.getGroups();
                assertThat(newContactGroups.size(),equalToObject( contactGroups.size() + 1));
                assertThat(newContactGroups, equalToObject(
                        contactGroups));
                break;
            }}

    }
}

        /*можно получить список контактов.
        /*потом в цикле искать подходящий контакт -- для каждого контакта строить список групп, в которые он не входит, и смотреть, если список пустой -- переходим к следующему контакту.
                а если непустой -- берём из него группу и подходящая пара найдена*/





