package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactDate;

/**
 * Created by goga on 02.08.2016.
 */
public class ContactHelper extends HelperBase {
    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactDate contactDate) {
        type(By.name("firstname"), contactDate.getFirstname());
        type(By.name("lastname"), contactDate.getLastname());
        type(By.name("email"), contactDate.getEmail());
    }

    public void submitContactForm() {
        click(By.name("submit"));
        //wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void goToHomePage() {
        click(By.linkText("home"));
        //wd.findElement(By.linkText("home")).click();
    }
}
