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

    @Step("Закрытие браузера")
    public void closePage() {
        driver.quit();
    }

    @Step("Инициализация страницы")
    public void initPage(String url) {
        driver.get(url);
    }

    @Step("Переключение на последнюю вкладку")
    public void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

}
