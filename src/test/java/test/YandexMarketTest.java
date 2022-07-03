package test;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.bars.FileManageBar;
import steps.MainTestSteps;
import steps.YandexDiskMainPageSteps;
import steps.YandexHomePageSteps;
import steps.YandexLoginPageSteps;
import steps.barSteps.FileManagerBarSteps;

import java.util.Date;
import java.util.concurrent.TimeUnit;


@Owner("Тимофеев")
@Feature("Работа с маркетом и поиском Яндекс.ру")
public class YandexMarketTest {

    ChromeDriver driver = new ChromeDriver();


    @Story("Переход в маркет и возврат к поиску")
    @Test
    public void test1() {
        String folderName = new Date().toString();
        System.out.println(folderName);
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
//        yandexDiskMainPageSteps.deleteSimbirsoftFolder();
//        yandexRuHomePageSteps.goToMarket();
//        mainTestSteps.initPage("https://market.yandex.ru/?clid=505&utm_source=main_stripe_big");
//        new MarketYandexRuHomePageSteps(driver).search("Honor");
//        buf = new MarketYandexRuHonorPageSteps(driver).copyOfSearchResultNumbOne();
//        mainTestSteps.initPage("https://yandex.ru");
//        yandexRuHomePageSteps.search(buf);
//        mainTestSteps.closePage();
    }

}
