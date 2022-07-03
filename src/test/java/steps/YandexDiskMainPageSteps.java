package steps;

import Utils.WaitUtil;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.YandexDiskMainPage;
import steps.barSteps.FileManagerBarSteps;

import java.io.FileReader;
import java.io.IOException;

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

        WaitUtil.waiting(4);
    }

    @Step("Операции с файлом")
    public void operationWithFile(String folderName) {
        YandexDiskMainPage yandexDiskMainPage = new YandexDiskMainPage(driver);
        yandexDiskMainPage.fileForCopying.click();
        FileManagerBarSteps fileManagerBarSteps = new FileManagerBarSteps(driver);
        fileManagerBarSteps.clickCopyButton();
        WaitUtil.waiting(2);
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

    @Step("Открытие папки")
    public void openFolder(String folderName) {
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(By.xpath("//span[@title=\"" + folderName + "\" and @class=\"clamped-text\"]/ancestor::div[@class=\"listing-item__info\"]"))).perform();
        WaitUtil.waiting(5);

    }

    @Step("Открытие файла")
    public void openFile(String fileName) {
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(By.xpath("//span[@title=\"" + fileName + "\"]/ancestor::div[contains(@class,'listing-item_type_file')]"))).perform();
        WaitUtil.waiting(1);
        new MainTestSteps(driver).switchToNewTab();
        WaitUtil.waiting(2);

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

    @Step("Загрузка файла с локальной машины")
    public void uploadFile() {
        YandexDiskMainPage yandexDiskMainPage = new YandexDiskMainPage(driver);
        String userDirectory = System.getProperty("user.dir") + "/" + "src/test/resources/textForExample.txt";
        yandexDiskMainPage.inputForUpload.sendKeys(userDirectory);
        WaitUtil.waiting(4);
    }

    @Step("Проверка соответствия текста")
    public void checkTextInFile() {

        String text = new String();
        try (FileReader reader = new FileReader("src/test/resources/textForExample.txt")) {
            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1) {
                text += (char) c;

            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"__page-1\"]/descendant::p")).getText().equals(text));
    }
}