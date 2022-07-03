package test;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.MainTestSteps;
import steps.YandexDiskMainPageSteps;
import steps.YandexHomePageSteps;
import steps.YandexLoginPageSteps;
import steps.barSteps.FileManagerBarSteps;

import java.util.Date;


@Owner("Тимофеев")
@Feature("Работа с маркетом и поиском Яндекс.ру")
public class YandexMarketTest {

    ChromeDriver driver = new ChromeDriver();


    @Story("Основное задание по UI")
    @Test
    public void test1() {
        String folderName = new Date().toString();
        driver.manage().window().setSize(new Dimension(1920, 1080));

        MainTestSteps mainTestSteps = new MainTestSteps(driver);
        YandexHomePageSteps yandexHomePageSteps = new YandexHomePageSteps(driver);

        mainTestSteps.initPage("https://yandex.ru");
        yandexHomePageSteps.clickLoginButton();

        YandexLoginPageSteps yandexLoginPageSteps = new YandexLoginPageSteps(driver);
        yandexLoginPageSteps.logIn();
        yandexHomePageSteps.clickDiskButton();

        mainTestSteps.switchToNewTab();
        YandexDiskMainPageSteps yandexDiskMainPageSteps = new YandexDiskMainPageSteps(driver);
        yandexDiskMainPageSteps.createNewFolder(folderName);

        yandexDiskMainPageSteps.operationWithFile(folderName);
        yandexDiskMainPageSteps.openFolder(folderName);
        yandexDiskMainPageSteps.checkFileIsExist();
        yandexDiskMainPageSteps.logOut();

        driver.quit();

    }

    @Story("Дополнительное задание UI (загрузка файла на Я.Диск)")
    @Test
    public void test2() {
        String folderName = new Date().toString();
        driver.manage().window().setSize(new Dimension(1920, 1080));

        MainTestSteps mainTestSteps = new MainTestSteps(driver);
        YandexHomePageSteps yandexHomePageSteps = new YandexHomePageSteps(driver);

        mainTestSteps.initPage("https://yandex.ru");
        yandexHomePageSteps.clickLoginButton();

        YandexLoginPageSteps yandexLoginPageSteps = new YandexLoginPageSteps(driver);
        yandexLoginPageSteps.logIn();
        yandexHomePageSteps.clickDiskButton();

        mainTestSteps.switchToNewTab();

        YandexDiskMainPageSteps yandexDiskMainPageSteps = new YandexDiskMainPageSteps(driver);
        yandexDiskMainPageSteps.createNewFolder(folderName);
        yandexDiskMainPageSteps.openFolder(folderName);
        yandexDiskMainPageSteps.uploadFile();
        yandexDiskMainPageSteps.openFile("textForExample.txt");
        yandexDiskMainPageSteps.checkTextInFile();

        mainTestSteps.closeCurrentTab();

        new FileManagerBarSteps(driver).clickCancelButton();
        yandexDiskMainPageSteps.logOut();
        driver.quit();

    }

}
