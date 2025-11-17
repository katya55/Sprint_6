package POM;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class AboutRent {

    private WebDriver driver;

    public By pageAboutRent = By.cssSelector(".Order_Header__BZXOb");
    public By dataInput = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    public By inputTimeOfRent = By.cssSelector(".Dropdown-control");
    public By timeOfRent = By.cssSelector(".Dropdown-option");
    public By blockOfColor = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/div");
    public By color = By.cssSelector(".Checkbox_Label__3wxSf");
    public By comment = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    public By buttonOrder = By.xpath("//div[contains(@class,'Order_Buttons__1xGrp')]//button[text()='Заказать']");
    public By doYouWantDoOder = By.xpath("//div[contains(@class, 'Order_ModalHeader') and contains(text(), 'Хотите оформить заказ')]");
    public By buttonYes = By.xpath("//div[contains(@class,'Order_Modal__YZ-d3')]//button[text()='Да']");
    public By modalOfOrder = By.xpath("//div[contains(@class, 'Order_ModalHeader') and contains(text(), 'Заказ оформлен')]");

    public AboutRent(WebDriver driver) {
        this.driver = driver;
    }  //*[@id="root"]/div/div[2]/div[5]/div[1]

    public void isPageAboutRent() {
        driver.findElement(pageAboutRent).isDisplayed();
    }
    public void setDate() {
        driver.findElement(dataInput).sendKeys("28.11.1994");
        driver.findElement(By.xpath("//div[@aria-label='Choose понедельник, 28-е ноября 1994 г.']")).click();
    }
    public void setTimeOfRent() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(inputTimeOfRent));
        driver.findElement(inputTimeOfRent).click();
        List<WebElement> times = driver.findElements(timeOfRent);

        Random random = new Random();
        int index = random.nextInt(times.size());
        times.get(index).click();
    }

    public void setColor() {
        driver.findElement(blockOfColor).click();
        List<WebElement> colors = driver.findElements(color);
        Random random = new Random();
        int index = random.nextInt(colors.size());
        colors.get(index).click();
    }

    public void setComment(String userComment) {
        driver.findElement(comment).sendKeys(userComment);
    }

    public void putButtonOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonOrder)).click();
    }

    //дождаться появление Вы хотите сделать заказа
    public boolean isDoYouWantDoOder() {
       return driver.findElement(doYouWantDoOder).isDisplayed();
    }
    //кликнуть Да
    public void putYes() {
        driver.findElement(buttonYes).click();
    }

    public void checkOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(modalOfOrder));
        driver.findElement(modalOfOrder).isDisplayed();

    }

    //Общий метод по заполнению полей на странице
    public void setInputs(String data, String time, String userColor, String userComment) {
        driver.findElement(dataInput).sendKeys(data);
        driver.findElement(By.xpath("//div[@aria-label='Choose понедельник, 28-е ноября 1994 г.']")).click();
        driver.findElement(inputTimeOfRent).click();
        driver.findElement(timeOfRent).click();
        driver.findElement(color).click();
        driver.findElement(comment).sendKeys("Позвоните, как приедете");
    }
}

