import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Date;

public class main {
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        System.out.println(date.toString().replaceAll(" ","").replaceAll(":",""));
    }
}
