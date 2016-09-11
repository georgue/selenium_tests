package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by goga on 02.08.2016.
 */
public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactDate contactDate, boolean creation) {
        type(By.name("firstname"), contactDate.getFirstname());
        type(By.name("lastname"), contactDate.getLastname());
        type(By.name("email"), contactDate.getEmail());
        // если мы на форме создания контакта поля новая группа быть должно
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDate.getGroup());
        } else {
            // проверяет что этого элемента нет на странице модификации контактов
            Assert.assertFalse(isAlertPresent(By.name("new_group")));
        }
    }

    public void submitContactForm() {
        click(By.name("submit"));
    }

    public void updateContactForm() {
        click(By.name("update"));
    }

    public void goToContactPage() {
        click(By.linkText("home"));
    }

    public void goToContactModficationForm() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void deleteContacts() {
        //click checkbox
        click(By.name("selected[]"));

        //click delete button
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));


    }

    public void createContact(ContactDate contactDate, boolean b) {
        gotoContactCreationForm();
        fillContactForm(contactDate, b);
        submitContactForm();
        goToContactPage();
    }

    private void gotoContactCreationForm() {
        click(By.linkText("add new"));
    }

    public void acceptAlert() {
        wd.switchTo().alert().accept();
    }

    public boolean isThisAContact() {
        return isAlertPresent(By.name(("selected[]")));

    }

    public boolean isThisAModificate() {
        return isAlertPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }


    public List<ContactDate> getContactList() {
        List<ContactDate> contacts = new ArrayList<ContactDate>();

        //List<WebElement> elementsLastNames = wd.findElements(By.xpath(".//*[@id='maintable']/tbody/tr[*]/td[2]"));
        //List<WebElement> elementsFirstNames = wd.findElements(By.xpath(".//*[@id='maintable']/tbody/tr[*]/td[3]"));
        //List<WebElement> elementsIds = wd.findElements(By.xpath(".//*[@id='maintable']/tbody/tr[*]/td[1]"));

        List <WebElement> elements = wd.findElements(By.xpath(".//*[@id='maintable']/tbody[*]/tr[@name]"));


        for (WebElement elem: elements) {

            String lastname = elem.findElement(By.xpath("//td[2]")).getText();
            String firstName = elem.findElement(By.xpath("//td[3]")).getText();
            Integer Id = Integer.parseInt(elem.findElement(By.tagName("input")).getAttribute("value"));
            ContactDate contact = new ContactDate(firstName, lastname, null, null, Id);
            contacts.add(contact);
        }
        return contacts;
    }

}

