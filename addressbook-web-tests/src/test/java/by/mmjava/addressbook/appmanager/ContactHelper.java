package by.mmjava.addressbook.appmanager;

import by.mmjava.addressbook.model.ContactData;
import by.mmjava.addressbook.model.Contacts;
import by.mmjava.addressbook.model.GroupData;
import by.mmjava.addressbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.sql.*;
import java.util.List;
import java.util.Set;

/**
 * Created by User on 4/23/2017.
 */
public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void viewCreatedContactData() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        } else {
            click(By.linkText("home"));  //click on Contact Data link
        }
    }

    public void submitContactData() {

        click(By.xpath("//div[@id='content']/form/input[21]"));
    }
    public void Home() {
        if (isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));
    }
    public void addContactData(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        attach(By.name("photo"),contactData.getPhoto());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompanyName());
        type(By.name("address"), contactData.getAddress2());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomeNumber());
        type(By.name("mobile"), contactData.getMobileNumber());
        type(By.name("work"), contactData.getWorkNumber());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("homepage"), contactData.getHomepage());
        type(By.name("byear"), contactData.getBirthYear());
        if (creation) {
            if ((contactData.getGroups().size()>0)){
                Assert.assertTrue(contactData.getGroups().size()==1);
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
            }else {
                Assert.assertFalse(isElementPresent(By.name("new_group")));
            }
            type(By.name("ayear"), contactData.getAnniversaryYear());
            type(By.name("address2"), contactData.getSecondaryAddress());
            type(By.name("phone2"), contactData.getSecondaryPhone());
            type(By.name("notes"), contactData.getSecondaryNotes());
        }}

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='"+ id + "']")).click();  //тэг инпут, имя value
    }

    public void clickEditContact(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click(); //think of similar ways of selector
    }

    public void submitUpdatedContactData() {
        click(By.name("update"));
    }

    public void deleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void create(ContactData contact) {
        gotoAddNewContact();
        addContactData(contact,true);
        //group can't be null?;
        submitContactData();
        contactsCache = null;
        viewCreatedContactData();
    }


    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        clickEditContact(contact.getId());
        deleteContact();
        contactsCache = null;
        viewCreatedContactData();
    }
    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        clickEditContact(contact.getId());
        addContactData(contact,false);
        submitUpdatedContactData();
        viewCreatedContactData();
    }
    public void addToGroup(ContactData contact) {
        //checkGroupsWithoutSelectedContact(contact.getId());
        contactAddToGroup(contact);
    }


    private void clickAddToGroup() {
        click(By.name("add"));
    }

    private void selectGroup() {
        //if (contact is present in group)
        Select group = new Select(wd.findElement(By.name("to_group")));
        }


    private void gotoAddNewContact() {
        click(By.xpath("//a[contains(text(),'add new')]"));
    }

    public Contacts contactsCache = null;

    public void contactAddToGroup(ContactData contactData){
        DbHelper db = new DbHelper();
        int groupsCount = db.groups().size();
        selectContactById(contactData.getId());
        List <Groups> groups = contactData.getGroups();
        for (int i=0; i<db.contacts().size(); i++){
            if (contactData.getGroups().size() != db.groups().size()){
                nv.Home();
            new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
            click(By.name("add"));
        } else {
            System.out.println("Selected contact already assigned to all %s groups");
        }}
        }
    public Contacts all() {
        if (contactsCache != null) {
            return new Contacts(contactsCache);
        }
        Contacts contacts = new Contacts();  //создание списка с именем контактов
        List <WebElement> elements = wd.findElements(By.name("entry")); //поиск элементов(контактов на странице)
        for (WebElement element : elements) //прохождение по каждому элементу выше в цикле, переменная element пробегает по списку elements
        {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String name = cells.get(2).getText();
            String second_name = cells.get(1).getText();
            String allPhones = cells.get(5).getText();
            String addresses = cells.get(3).getText();
            String emails = cells.get(4).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstname(name).withLastname(second_name).withAllPhones(allPhones).withAddress(addresses).withAllEmails(emails));
        }
        return contacts;
    }

    public ContactData gluedInfoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        if (!firstname.isEmpty()) {firstname = firstname+" ";}
        String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
        if (!middlename.isEmpty()) {middlename = middlename+" ";}
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        if (!lastname.isEmpty()) {lastname = lastname+"\n";}
        String home = wd.findElement(By.name("home")).getAttribute("value");
        if (!home.isEmpty()) {home = "H: " + home + "\n";}
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        if (!mobile.isEmpty()) {mobile = "M: " + mobile + "\n";}
        String work = wd.findElement(By.name("work")).getAttribute("value");
        if (!work.isEmpty()) {work = "W: " + work + "\n\n";}
        String addresses = wd.findElement(By.name("address")).getAttribute("value");
        if (!addresses.isEmpty()) {addresses = addresses+"\n\n";}
        String email = wd.findElement(By.name("email")).getAttribute("value");
        if (!email.isEmpty()) {email = email+"\n";}
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        if (!email2.isEmpty()) {email2 = email2+"\n";}
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String allContactData = firstname+middlename+lastname
                +addresses+home+mobile+work+email+email2+email3;
        //String fullContactData = allContactData.replaceAll("\\s","");
        wd.navigate().back();
        return  new ContactData().withId(contact.getId()).withAllContactData(allContactData);}

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String homephone2 = wd.findElement(By.name("phone2")).getAttribute("value");
        String addresses = wd.findElement(By.name("address")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return  new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).
                withHomeNumber(home).withAddress(addresses).withMobileNumber(mobile).withWorkNumber(work).
                withSecondaryPhone(homephone2).withEmail(email).withEmail2(email2).withEmail3(email3);}

    public void initContactModificationById (int id)
    {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']",id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List <WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
//        wd.findElement(By.xpath(String.format("//input[@value='%s']../../td[8]/a",id))).click();
//        wd.findElement(By.xpath(String.format("//tr[.//input[@value'%s']]/td[8]/a",id))).click();
//        wd.findElement(By.xpath(String.format("a[href='edit.php?id=%s']",id))).click();
    }

    public ContactData infoFromContactPage(ContactData contact) {
        initContactPageById(contact.getId());
        String allContactData = wd.findElement(By.id("content")).getText();
        wd.navigate().back();
        return  new ContactData().withId(contact.getId()).withAllContactData(allContactData);}

    private void initContactPageById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
    }


}

