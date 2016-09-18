package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;


public class ContactCreationTests extends TestBase {

    @Test(enabled = false)
    public void testContactCreationTests() {
        List<ContactDate> before = app.getContactHelper().getContactList();
        app.goTo().gotoContactCreationForm();
        ContactDate contact = new ContactDate("goga", "vibel", "goga.vibel@mail.ru", "test1");
        app.getContactHelper().createContact(contact, true);
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactDate> ById = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals( before , after);

    }
}

