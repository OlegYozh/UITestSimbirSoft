package steps.barSteps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.bars.FileManageBar;

public class FileManagerBarSteps {

    public FileManagerBarSteps() {
    }

    public FileManagerBarSteps(WebDriver driver) {
        this.driver = driver;
    }


    private WebDriver driver;

    @Step("������� ������ ����������")
    public void clickCopyButton() {
        FileManageBar fileManageBar = new FileManageBar(driver);
        fileManageBar.copyButton.click();

    }

    @Step("������� ������ �������")
    public void clickDeleteButton() {
        FileManageBar fileManageBar = new FileManageBar(driver);
        fileManageBar.deleteButton.click();

    }
}