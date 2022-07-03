package steps;

import Utils.WaitUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.YandexHomePage;

public class YandexHomePageSteps {

    public YandexHomePageSteps() {
    }

    public YandexHomePageSteps(WebDriver driver) {
        this.driver = driver;
    }


    private WebDriver driver;


    @Step
    public void findYandexMyself(String query) {
        WebElement searchField = driver.findElement(By.xpath("//input[@id=\"text\"]"));
        searchField.sendKeys(query);
        WebElement submitButton = driver.findElement(By.xpath("//div[@class=\"search2__button\"]/button"));
        submitButton.submit();
    }

    @Step
    public void clickResult() {
        WebElement searchResult = driver.findElement(By.xpath("//ul[@id=\"search-result\"]/li[2]/div/div/div[2]/h2/a"));
        searchResult.click();
    }


    @Step
    public void getTitleOf3FirstNews() {
        WebElement firstTopic = driver.findElement(By.xpath("//*[@id=\"news_panel_news\"]/ol[1]/li[1]/a/span/span"));
        WebElement secondTopic = driver.findElement(By.xpath("//*[@id=\"news_panel_news\"]/ol[1]/li[2]/a/span/span"));
        WebElement thirdTopic = driver.findElement(By.xpath("//*[@id=\"news_panel_news\"]/ol[1]/li[3]/a/span/span"));
        WebElement title = driver.findElement(By.xpath("//div[@aria-label=\"Дзен\"]/div[1]/div/div[1]/text()"));

        System.out.println(firstTopic.getText());
        System.out.println(secondTopic.getText());
        System.out.println(thirdTopic.getText());
        System.out.println();
        System.out.println(title.getText());
    }

    @Step("Переход в маркет")
    public void goToMarket() {
        YandexHomePage yandexHomePage = new YandexHomePage(driver);
        yandexHomePage.marketButton.click();
    }

    @Step("Поиск в яндексе")
    public void search(String search) {
        YandexHomePage yandexHomePage = new YandexHomePage(driver);
        yandexHomePage.searchString.sendKeys(search);
        yandexHomePage.searchString.submit();
    }

    @Step("Нажатие кнопки \"Войти\"")
    public void clickLoginButton() {
        WaitUtil.waiting(2);
        YandexHomePage yandexHomePage = new YandexHomePage(driver);
        yandexHomePage.loginButton.click();
        WaitUtil.waiting(2);
    }

    @Step("Нажатие кнопки \"Диск\"")
    public void clickDiskButton() {
        driver.findElement(By.xpath(" //a[contains(@data-statlog,'disk')]")).click();
        WaitUtil.waiting(2);

    }
}