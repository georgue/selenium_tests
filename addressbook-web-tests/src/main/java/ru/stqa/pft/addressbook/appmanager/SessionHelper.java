package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by goga on 26.07.2016.
 */
public class SessionHelper extends HelperBase {

    public SessionHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        type(By.name("pass"),password);
        type(By.name("user"),username);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }

}
