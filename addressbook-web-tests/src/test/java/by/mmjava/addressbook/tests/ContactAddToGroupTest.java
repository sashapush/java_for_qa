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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static by.mmjava.addressbook.tests.TestBase.app;

/**
 * Created by User on 6/6/2017.
 */
public class ContactAddToGroupTest extends TestBase {
    private SessionFactory sessionFactory;
    //@BeforeMethod
    /*public void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            e.printStackTrace();
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }*/



    @Test
    public void testContactAddToGroup(){
        app.goTo().Home();
        Contacts before = app.db().contacts();  // получен список контактов
        for (int i=0;i<app.db().contacts().size();i++){
            ContactData modifiedContact = before.iterator().next();
            Set <GroupData> allGroups=app.db().groups();
            Set <GroupData> contactGroups = modifiedContact.getGroups();
            Set <GroupData> availableGroups = modifiedContact.getGroups();
            if ( allGroups.size() != contactGroups.size() ) {
                new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(availableGroups.iterator().next().getName());
                click(By.name("add"));
            }else {
                System.out.println("wasted, no more contacts for addition");
            }
            app.contact().addToGroup(modifiedContact);
        }

        /*можно получить список контактов. потом в цикле искать подходящий контакт -- для каждого контакта строить список групп, в которые он не входит, и смотреть, если список пустой -- переходим к следующему контакту.
                а если непустой -- берём из него группу и подходящая пара найдена*/

        }

}
