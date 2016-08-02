package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreationTests() {
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().fillContactForm(new ContactDate("goga", "vibel", "goga.vibel@mail.ru"));
        app.getContactHelper().submitContactForm();
        app.getContactHelper().goToHomePage();

    }


}

