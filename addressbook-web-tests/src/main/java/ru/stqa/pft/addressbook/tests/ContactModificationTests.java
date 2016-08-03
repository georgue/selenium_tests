package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

/**
 * Created by goga on 03.08.2016.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testsContactModification(){
        app.getContactHelper().goToContactModficationForm();
        app.getContactHelper().fillContactForm(new ContactDate("masha", "vogov", "masha-vogov@mail.ru"));
        app.getContactHelper().updateContactForm();
        app.getContactHelper().goToContactPage();
    }

}
