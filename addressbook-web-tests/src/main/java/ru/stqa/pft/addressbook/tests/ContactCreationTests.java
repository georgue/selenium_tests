package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreationTests() {
        app.getNavigationHelper().gotoContactCreationForm();
        app.getContactHelper().createContact(new ContactDate("goga", "vibel", "goga.vibel@mail.ru", "test1"),true);
    }
}

