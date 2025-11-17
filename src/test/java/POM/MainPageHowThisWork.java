package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPageHowThisWork {

    private WebDriver driver;
    public By howThisWork = By.className("Home_SubHeader__zwi_E");
    public By buttonOrderDown = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");

    public MainPageHowThisWork(WebDriver driver) {
        this.driver = driver;
    }

    public void scroll() {
        var element = driver.findElement(howThisWork);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //клик по заказать(нижней)
    public void putButtonOrderDown() {
        driver.findElement(buttonOrderDown).click();
    }


}
