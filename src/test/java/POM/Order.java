package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Order {

    private WebDriver driver;
    public By pageForScooter = By.className("Order_Header__BZXOb");

    public By firstName = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    public By lastName = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    public By address = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    public By inputMetro = By.xpath("//input[@placeholder='* Станция метро']");
    public By metroStations = By.cssSelector("button.Order_SelectOption__82bhS .Order_Text__2broi");
    public By phone = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    public By buttonContinue = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");



    public Order(WebDriver driver) {
        this.driver = driver;
    }

    //проверка появления страницы
    public boolean isPageOpenPageForScooter() {

        return driver.findElement(pageForScooter).isDisplayed();
    }

    //нажать далее
    public void putContinue() {
        driver.findElement(buttonContinue).click();
    }

    //общий метод для заполнения полей
    public void setInputOrder(String userFirstName, String userLastName, String userAddress, String userPhone) {
        driver.findElement(firstName).sendKeys(userFirstName);
        driver.findElement(lastName).sendKeys(userLastName);
        driver.findElement(address).sendKeys(userAddress);
        driver.findElement(phone).sendKeys(userPhone);
    }

    public void chooseRandomStation() {
        driver.findElement(inputMetro).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(metroStations));
        List<WebElement> allStations = driver.findElements(metroStations);
        Random random = new Random();
        int index = random.nextInt(allStations.size());
        allStations.get(index).click();
    }



}
