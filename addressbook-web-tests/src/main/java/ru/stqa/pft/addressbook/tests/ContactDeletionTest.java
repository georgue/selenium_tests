package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by goga on 03.08.2016.
 */
public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion(){
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().deleteAllContacts();
        app.getContactHelper().acceptAlert();
    }
}
