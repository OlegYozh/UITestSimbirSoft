package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class MainTestSteps {

    private WebDriver driver;

    public MainTestSteps() {
    }

    public MainTestSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("�������� ��������")
    public void closePage() {
        driver.quit();
    }

    @Step("������������� ��������")
    public void initPage(String url) {
        driver.get(url);
    }

    @Step("������������ �� ��������� �������")
    public void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

}
