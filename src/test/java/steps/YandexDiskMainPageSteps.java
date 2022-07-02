package steps;

import Utils.WaitUtil;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import pages.YandexDiskMainPage;
import pages.YandexHomePage;
import steps.barSteps.FileManagerBarSteps;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class YandexDiskMainPageSteps {

    public YandexDiskMainPageSteps() {
    }

    public YandexDiskMainPageSteps(WebDriver driver) {
        this.driver = driver;
    }


    private WebDriver driver;

    @Step("Создание новой папки")
    public void createNewFolder(String folderName) {
        YandexDiskMainPage yandexDiskMainPage = new YandexDiskMainPage(driver);
        yandexDiskMainPage.createButton.click();
        yandexDiskMainPage.newFolderButton.click();

        driver.findElement(By.xpath("//input[@value=\"Новая папка\"]")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        driver.findElement(By.xpath("//form[@class=\"rename-dialog__rename-form\"]/descendant::input")).sendKeys(folderName);

        driver.findElement(By.xpath("//span[text()='Сохранить']/parent::button")).click();

        new WaitUtil().waiting(4);
    }

    @Step("Операции с файлом")
    public void operationWithFile(String folderName) {
        YandexDiskMainPage yandexDiskMainPage = new YandexDiskMainPage(driver);
        yandexDiskMainPage.fileForCopying.click();
        FileManagerBarSteps fileManagerBarSteps = new FileManagerBarSteps(driver);
        fileManagerBarSteps.clickCopyButton();
        new WaitUtil().waiting(2);
        driver.findElement(By.xpath("//div[@class=\"b-tree__name\" and @title=\"" + folderName + "\"]")).click();
        driver.findElement(By.xpath("//span[text()='Копировать']/parent::button[contains(@class,'submit')]")).click();
    }

//    @Step("Удаление папки Симбирсофт")
//    public void deleteSimbirsoftFolder() {
//        YandexDiskMainPage yandexDiskMainPage = new YandexDiskMainPage(driver);
//        yandexDiskMainPage.folderSimbirSOft.click();
//        FileManagerBarSteps fileManagerBarSteps = new FileManagerBarSteps(driver);
//        fileManagerBarSteps.clickDeleteButton();
//
//    }

    @Step("Открытие папки Симбирсофт")
    public void openFolder(String folderName) {
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(By.xpath("//span[@title=\""+folderName+"\" and @class=\"clamped-text\"]/ancestor::div[@class=\"listing-item__info\"]"))).perform();
        new WaitUtil().waiting(5);

    }

    @Step("Проверка наличия файла")
    public void checkFileIsExist() {
        Assert.assertTrue(new YandexDiskMainPage(driver).fileForCopying.isDisplayed());
    }

    @Step("ЛогАут")
    public void logOut() {
        YandexDiskMainPage yandexDiskMainPage = new YandexDiskMainPage(driver);
        yandexDiskMainPage.accountButton.click();
        yandexDiskMainPage.logoutButton.click();

    }
}