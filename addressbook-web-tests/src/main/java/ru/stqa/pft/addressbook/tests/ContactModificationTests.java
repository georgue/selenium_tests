package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;

/**
 * Created by goga on 03.08.2016.
 */
public class ContactModificationTests extends TestBase {

    @Test(enabled = false)
    public void testsContactModification(){
        app.goTo().gotoHomePage();
        List<ContactDate> before = app.getContactHelper().getContactList();
        if(! app.getContactHelper().isThisAModificate()) {
            app.getContactHelper().createContact(new ContactDate("zz", "zz_z", "zz.zz_z@mail.ru", "test1"), true);
        }
        app.getContactHelper().goToContactModficationForm();
        //
        ContactDate contactDate = new ContactDate("zz_mod", "zz_z_mod", "zz.zz_mod@mail.ru", "test1", before.get(before.size() - 1).getId());
        app.getContactHelper().fillContactForm(contactDate, false);
        app.getContactHelper().updateContactForm();
        app.getContactHelper().goToContactPage();
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());
        before.remove(before.size() - 1);
        before.add(contactDate);
        Comparator<? super ContactDate> ById = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(ById);
        after.sort(ById);

        Assert.assertEquals( before , after);
    }

}
