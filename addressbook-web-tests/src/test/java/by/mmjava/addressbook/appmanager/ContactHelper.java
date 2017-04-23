package by.mmjava.addressbook.appmanager;

import by.mmjava.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by User on 4/23/2017.
 */
public class ContactHelper extends HelperBase
{
    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void viewCreatedContactData() {
        wd.findElement(By.xpath("//div/div[4]/div/i/a[2]")).click();  //click on Contact Data
    }

    public void submitContactData() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }
    public void addContactData(ContactData contactData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(contactData.getCompanyName());
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(contactData.getAddress1());
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(contactData.getHomeNumber());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(contactData.getMobileNumber());
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys(contactData.getWorkNumber());
        wd.findElement(By.name("fax")).click();
        wd.findElement(By.name("fax")).clear();
        wd.findElement(By.name("fax")).sendKeys(contactData.getFax());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
        wd.findElement(By.name("email2")).click();
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys(contactData.getEmail2());
        wd.findElement(By.name("email3")).click();
        wd.findElement(By.name("email3")).clear();
        wd.findElement(By.name("email3")).sendKeys(contactData.getEmail3());
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys(contactData.getHomepage());
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[2]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[14]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[14]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[14]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[14]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[14]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[14]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[1]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).click();
        }
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(contactData.getBirthYear());
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[1]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[2]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[3]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[3]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[14]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[14]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[14]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[14]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[14]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[14]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[1]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[2]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[7]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[7]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[7]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[7]")).click();
        }
        wd.findElement(By.name("ayear")).click();
        wd.findElement(By.name("ayear")).clear();
        wd.findElement(By.name("ayear")).sendKeys(contactData.getAnniversaryYear());
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).click();
        }
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys(contactData.getSecondaryAddress());
        wd.findElement(By.name("phone2")).click();
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys(contactData.getSecondaryPhone());
        wd.findElement(By.name("notes")).click();
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys(contactData.getSecondaryNotes());
    }

    public void gotoAddNewContact() {
        wd.findElement(By.linkText("add new")).click();
    }
}
