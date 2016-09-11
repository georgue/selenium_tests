package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.List;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreationTests() {
        List<ContactDate> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoContactCreationForm();
        app.getContactHelper().createContact(new ContactDate("goga", "vibel", "goga.vibel@mail.ru", "test1", 0),true);
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

    }
}

