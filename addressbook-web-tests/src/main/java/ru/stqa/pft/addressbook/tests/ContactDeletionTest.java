package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.List;

/**
 * Created by goga on 03.08.2016.
 */
public class ContactDeletionTest extends TestBase {

    @Test(enabled = false)
    public void testContactDeletion(){
        app.goTo().gotoHomePage();
        if (! app.getContactHelper().isThisAContact()){
            app.getContactHelper().createContact(new ContactDate("zz", "zz_z", "zz.zz_z@mail.ru", "test1", 0),true);
        }
        List<ContactDate> before = app.getContactHelper().getContactList();
        app.getContactHelper().deleteContacts();
        app.getContactHelper().acceptAlert();
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(0);


        Assert.assertEquals(after, before);

    }
}
