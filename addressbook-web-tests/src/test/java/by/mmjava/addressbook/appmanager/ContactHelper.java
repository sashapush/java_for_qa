package by.mmjava.addressbook.appmanager;

import by.mmjava.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by User on 4/23/2017.
 */
public class ContactHelper extends HelperBase{
    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }
    public void viewCreatedContactData() {
        click(By.xpath("//div/div[4]/div/i/a[2]"));  //click on Contact Data
    }
    public void submitContactData() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }
    public void addContactData(ContactData contactData) {
        type(By.name("firstname"),contactData.getFirstname());
        type(By.name("middlename"),contactData.getMiddlename());
        type(By.name("lastname"),contactData.getLastname());
        type(By.name("nickname"),contactData.getNickname());
        type(By.name("title"),contactData.getTitle());
        type(By.name("company"),contactData.getCompanyName());
        type(By.name("address"),contactData.getAddress1());
        type(By.name("address"),contactData.getAddress());
        type(By.name("home"),contactData.getHomeNumber());
        type(By.name("mobile"),contactData.getMobileNumber());
        type(By.name("work"),contactData.getWorkNumber());
        type(By.name("fax"),contactData.getFax());
        type(By.name("email"),contactData.getEmail());
        type(By.name("email2"),contactData.getEmail2());
        type(By.name("email3"),contactData.getEmail3());
        type(By.name("homepage"),contactData.getHomepage());
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
        type(By.name("byear"),contactData.getBirthYear());
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
        type(By.name("ayear"),contactData.getAnniversaryYear());
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[5]//option[1]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[5]//option[2]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[5]//option[2]"));
        }
        type(By.name("address2"),contactData.getSecondaryAddress());
        type(By.name("phone2"),contactData.getSecondaryPhone());
        type(By.name("notes"),contactData.getSecondaryNotes());
    }
}
