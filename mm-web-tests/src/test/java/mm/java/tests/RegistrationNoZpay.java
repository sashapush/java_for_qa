package mm.java.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class RegistrationNoZpay {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }
    
    @Test
    public void RegistrationNoZpay() {
        // to do http authorisation
        // 2) dual-layer test framework
        // 3) delegation + extension
        // 4) extract methods - type(),
        // 5) add locators
        wd.get("https://qa-delivery-pl-master.moneyman.ru/secure/registration");
        wd.findElement(By.cssSelector("div.form__body.form__body_type_center")).click();
        wd.findElement(By.id("phone")).click();
        wd.findElement(By.id("phone")).clear();
        wd.findElement(By.id("phone")).sendKeys("512-512-657");
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).clear();
        wd.findElement(By.id("email")).sendKeys("testenai2@test.com");
        wd.findElement(By.id("next-button")).click();
        wd.findElement(By.id("phoneCode")).click();
        wd.findElement(By.id("phoneCode")).clear();
        wd.findElement(By.id("phoneCode")).sendKeys("1111");
        wd.findElement(By.id("send-button")).click();
        wd.findElement(By.id("firstName")).click();
        wd.findElement(By.id("firstName")).clear();
        wd.findElement(By.id("firstName")).sendKeys("sas");
        wd.findElement(By.id("lastName")).click();
        wd.findElement(By.id("lastName")).clear();
        wd.findElement(By.id("lastName")).sendKeys("sasa");
        wd.findElement(By.id("pesel")).click();
        wd.findElement(By.id("pesel")).clear();
        wd.findElement(By.id("pesel")).sendKeys("1111");
        wd.findElement(By.id("lastName")).click();
        wd.findElement(By.id("lastName")).clear();
        wd.findElement(By.id("lastName")).sendKeys("sasa");
        wd.findElement(By.id("nationalIdNumber")).click();
        wd.findElement(By.id("nationalIdNumber")).clear();
        wd.findElement(By.id("nationalIdNumber")).sendKeys("1111");
        wd.findElement(By.linkText("Wybierz wartość")).click();
        wd.findElement(By.cssSelector("li.active-result.result-selected")).click();
        wd.findElement(By.linkText("Wybierz wartość")).click();
        wd.findElement(By.xpath("//div[@id='dependants_chzn']//li[.='1']")).click();
        wd.findElement(By.id("next-button")).click();
        wd.findElement(By.id("registrationAddress_address")).click();
        wd.findElement(By.id("registrationAddress_address")).clear();
        wd.findElement(By.id("registrationAddress_address")).sendKeys("31");
        wd.findElement(By.cssSelector("div.autocomplete-suggestion.autocomplete-selected")).click();
        wd.findElement(By.xpath("//form[@id='form__order']/div[1]/div/div/div[2]/div[1]/label/span")).click();
        wd.findElement(By.id("registrationAddress_number")).click();
        wd.findElement(By.id("registrationAddress_number")).clear();
        wd.findElement(By.id("registrationAddress_number")).sendKeys("31");
        wd.findElement(By.cssSelector("span.icr__text")).click();
        wd.findElement(By.xpath("//span[@id='icr-2']/span[2]")).click();
        wd.findElement(By.cssSelector("div.form__end")).click();
        wd.findElement(By.id("next-button")).click();
        wd.findElement(By.linkText("Wybierz wartość")).click();
        wd.findElement(By.cssSelector("li.active-result.result-selected")).click();
        wd.findElement(By.linkText("Wybierz wartość")).click();
        wd.findElement(By.xpath("//div[@id='employment_chzn']//li[.='Rolnik']")).click();
        wd.findElement(By.id("income")).click();
        wd.findElement(By.id("income")).clear();
        wd.findElement(By.id("income")).sendKeys("1231");
        wd.findElement(By.cssSelector("span.icr__text")).click();
        wd.findElement(By.id("income")).click();
        wd.findElement(By.cssSelector("div.form__end")).click();
        wd.findElement(By.id("next-button")).click();
        wd.findElement(By.id("iban")).click();
        wd.findElement(By.id("iban")).clear();
        wd.findElement(By.id("iban")).sendKeys("26 1050 1764 1000 0090 6584 6470");
        wd.findElement(By.id("next-button")).click();
        wd.findElement(By.linkText("Pomiń →")).click();
        wd.findElement(By.linkText("Identyfikacja za pomocą zPay →")).click();
        wd.findElement(By.id("goToZpay")).click();
        wd.navigate().back();
        wd.get("https://qa-delivery-pl-master.moneyman.ru/secure/registration/step8");
        wd.findElement(By.cssSelector("span.icr__checkbox")).click();
        wd.findElement(By.xpath("//div[@id='calc-offer-block']/div/div/span[3]")).click();
        wd.findElement(By.xpath("//span[@id='icr-2']/span[1]")).click();
        wd.findElement(By.cssSelector("span.icr__checkbox")).click();
        wd.findElement(By.xpath("//span[@id='icr-3']/span[1]")).click();
        wd.findElement(By.cssSelector("span.icr__checkbox")).click();
        wd.findElement(By.id("offer-confirm")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
