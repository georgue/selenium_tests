package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

/**
 * Created by goga on 03.08.2016.
 */
public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion(){
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThisAContact()){
            app.getContactHelper().createContact(new ContactDate("goga", "vibel", "goga.vibel@mail.ru", "test1"),true);
        }
        app.getContactHelper().deleteContacts();
        app.getContactHelper().acceptAlert();
    }
}
