package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexHomePage {
    public WebDriver driver;

    public YandexHomePage() {
    }

    public YandexHomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[.=\"Маркет\"]")
    public WebElement marketButton;

    @FindBy(xpath = "//input[@aria-label=\"Запрос\"]")
    public WebElement searchString;

    @FindBy(xpath = "//div[text()='Войти']/parent::a")
    public WebElement loginButton;

}
