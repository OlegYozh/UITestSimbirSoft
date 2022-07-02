package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexLoginPage {
    public WebDriver driver;

    public YandexLoginPage() {
    }

    public YandexLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[contains(@data-t,'field:input')]")
    public WebElement inputField;

    @FindBy(xpath = "//button[@class=\"Button2 Button2_size_l Button2_view_action Button2_width_max Button2_type_submit\"]")
    public WebElement enterButton;

    @FindBy(xpath = "//span[text()='Почта']/parent::button")
    public WebElement mailButton;



}
