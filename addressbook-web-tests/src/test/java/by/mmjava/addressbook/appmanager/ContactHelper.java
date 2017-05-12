package by.mmjava.addressbook.appmanager;

import by.mmjava.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

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
            click(By.xpath("//div/div[4]/div/i/a[2]"));  //click on Contact Data
        }
    }

    public void submitContactData() {

        click(By.xpath("//div[@id='content']/form/input[21]"));
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

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void clickEditContact(int index) {
        wd.findElements(By.xpath("//../td[8]/a/img")).get(index).click(); //click in the 8th column of "index" row;
        //wd.findElements(By.cssSelector("td:nth-child(8) > a")).get(index).click(); same
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

    public void contactCreation() {
        gotoAddNewContact();
        addContactData(new ContactData(0,"alex", null, "last", "nick", "title", "company name", "address 1", "12345", "67894", "54577", "11", "tests@tests.com", "test2@tests.com", "test3@tests.com", "http://tests.com", "address 1\naddress 2", "1992", "2222", "test1", "secondary address", "secondary home", "secondary notes"), true);
        //group can't be null?;
        submitContactData();
    }
    private void gotoAddNewContact() {
        click(By.xpath("//a[contains(text(),'add new')]"));
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();  //создание списка с именем контактов
        List<WebElement> elements = wd.findElements(By.name("entry")); //поиск элементов(контактов на странице)
        for (WebElement element : elements) //прохождение по каждому элементу выше в цикле, переменная element пробегает по списку elements
        {
            List<WebElement> cells = wd.findElements(By.tagName("td"));
            String second_name = cells.get(2).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id,name,null,second_name,null,null,null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null,null,null,null);
            contacts.add(contact);
        }
        return contacts;
    }
}

