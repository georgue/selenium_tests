package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactDate;

/**
 * Created by goga on 02.08.2016.
 */
public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
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

    public void updateContactForm(){
        click(By.name("update"));
    }

    public void goToContactPage() {
        click(By.linkText("home"));
        //wd.findElement(By.linkText("home")).click();
    }

    public void goToContactModficationForm() {
        click(By.linkText("home"));
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void deleteAllContacts() {
        //click selectall checkbox
        click(By.id("MassCB"));
        //click delete button
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void acceptAlert() {
        wd.switchTo().alert().accept();
    }
}
