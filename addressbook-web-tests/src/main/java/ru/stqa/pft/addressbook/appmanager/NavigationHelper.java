package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by goga on 26.07.2016.
 */
public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        // оптимизация проверяем на какой страницы мы находимся
        // страница с надписью группы и у которой  есть кнопка создания новой группы
        if ( isAlertPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isAlertPresent(By.name("new"))){
            return;
        }
        click(By.linkText("groups"));
    }

    public void gotoContactCreationForm() {
        click(By.linkText("add new"));
    }

    public void gotoHomePage() {
        // оптимизация проверяем что мы на главной странице со списком контактов (проверяем на наличие таблицы)
        if (isAlertPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));

    }


}
