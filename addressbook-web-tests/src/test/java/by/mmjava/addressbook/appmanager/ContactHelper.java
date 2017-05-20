package by.mmjava.addressbook.appmanager;

import by.mmjava.addressbook.model.ContactData;
import by.mmjava.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.HashSet;
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
        //click(By.name("photo"));
        //click(By.xpath("//form[@id='LoginForm']/input[3]"));
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompanyName());
        type(By.name("address"), contactData.getAddress1());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomeNumber());
        type(By.name("mobile"), contactData.getMobileNumber());
        type(By.name("work"), contactData.getWorkNumber());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("homepage"), contactData.getHomepage());
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[1]//option[1]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[2]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[1]//option[2]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[1]//option[3]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[14]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[1]//option[14]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[14]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[1]//option[14]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[14]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[1]//option[14]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[1]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[2]//option[1]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[2]//option[2]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[2]//option[7]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[2]//option[7]"));
        }
        type(By.name("byear"), contactData.getBirthYear());
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[1]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[3]//option[1]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[2]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[3]//option[2]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[3]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[3]//option[3]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[14]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[3]//option[14]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[14]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[3]//option[14]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[14]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[3]//option[14]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[1]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[4]//option[1]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[2]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[4]//option[2]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[7]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[4]//option[7]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[7]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[4]//option[7]"));
        }
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
                    /*if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[5]//option[1]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[5]//option[2]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[5]//option[2]"));
        }*/
        }
        type(By.name("ayear"), contactData.getAnniversaryYear());
        type(By.name("address2"), contactData.getSecondaryAddress());
        type(By.name("phone2"), contactData.getSecondaryPhone());
        type(By.name("notes"), contactData.getSecondaryNotes());

    }

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
    private void gotoAddNewContact() {
        click(By.xpath("//a[contains(text(),'add new')]"));
    }

    public Contacts contactsCache = null;

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
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstname(name).withLastname(second_name));
        }
        return contacts;
    }



}

