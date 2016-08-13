package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactDate;

/**
 * Created by goga on 02.08.2016.
 */
public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactDate contactDate, boolean creation ) {
        type(By.name("firstname"), contactDate.getFirstname());
        type(By.name("lastname"), contactDate.getLastname());
        type(By.name("email"), contactDate.getEmail());
        // если мы на форме создания контакта поля новая группа быть должно
        if (creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDate.getGroup());
        } else {
            // проверяет что этого элемента нет на странице модификации контактов
            Assert.assertFalse(isAlertPresent(By.name("new_group")));
        }
    }

    public void submitContactForm() {
        click(By.name("submit"));
    }

    public void updateContactForm(){
        click(By.name("update"));
    }

    public void goToContactPage() {
        click(By.linkText("home"));
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
