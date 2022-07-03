package steps;

import Utils.WaitUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.YandexLoginPage;

public class YandexLoginPageSteps {

    public YandexLoginPageSteps() {
    }

    public YandexLoginPageSteps(WebDriver driver) {
        this.driver = driver;
    }


    private WebDriver driver;

    @Step("¬вод логина")
    public void logIn() {
        YandexLoginPage yandexLoginPage = new YandexLoginPage(driver);
        yandexLoginPage.mailButton.click();

        yandexLoginPage.inputField.sendKeys("SimbirSoftTestTimofeev");
        yandexLoginPage.enterButton.click();

        WaitUtil.waiting(2);
        yandexLoginPage.inputField.sendKeys("Mayhem95!");
        yandexLoginPage.enterButton.click();
        WaitUtil.waiting(2);


    }
}