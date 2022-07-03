package pages.bars;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileManageBar {
    public WebDriver driver;

    public FileManageBar() {
    }

    public FileManageBar(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@aria-label=\"����������\"]")
    public WebElement copyButton;

    @FindBy(xpath = "//button[@aria-label=\"�������\"]")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[@aria-label=\"���\"]")
    public WebElement moreButton;

    @FindBy(xpath = "//button[@aria-label=\"�������� ���������\"]")
    public WebElement cancelButton;


}
