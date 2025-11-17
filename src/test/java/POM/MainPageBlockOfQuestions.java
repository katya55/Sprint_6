package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPageBlockOfQuestions {

    private WebDriver driver;
    public By importantQuestions = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[1]");

    public MainPageBlockOfQuestions(WebDriver driver) {
        this.driver = driver;
    }


    //Скролл до блока с вопросами
    public void scroll() {
        var element = driver.findElement(importantQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
