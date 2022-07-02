package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexDiskMainPage {
    public WebDriver driver;

    public YandexDiskMainPage() {
    }

    public YandexDiskMainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[text()='Создать']/parent::button")
    public WebElement createButton;

    @FindBy(xpath = "//span[text()='Папку']//parent::button")
    public WebElement newFolderButton;

    @FindBy(xpath = "//span[contains(@title,'Файл для копирования')]/ancestor::div[contains(@class,'js-prevent-deselect')]")
    public WebElement fileForCopying;

    @FindBy(xpath = "//span[contains(text(),'СимбирСофт')]/ancestor::div[contains(@class,'js-prevent-deselect')]")
    public WebElement folderSimbirSOft;

    @FindBy(xpath = "//a[@aria-label=\"Аккаунт\"]")
    public WebElement accountButton;

    @FindBy(xpath = "//span[text()='Выйти']/parent::a")
    public WebElement logoutButton;

}
