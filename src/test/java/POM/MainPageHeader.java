package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageHeader {

    private WebDriver driver;
    public By cookie = By.id("rcc-confirm-button");
    public By buttonOrderUP = By.xpath("//button[contains(@class,'Button_Button__ra12g')]");
    public By logoScooter = By.cssSelector(".Header_LogoScooter__3lsAR");
    public By logoYandex = By.cssSelector(".Header_LogoYandex__3TSOI");


    public MainPageHeader(WebDriver driver) {
        this.driver = driver;
    }

    //Закрытие кук
    public void closeCookie() {
        driver.findElement(cookie).click();
    }

    //клик по заказать(верхней)
    public void putButtonOrderUP() {
        driver.findElement(buttonOrderUP).click();
    }

    //клик по лого самоката
    public void pushLogoScooter() {
        driver.findElement(logoScooter).click();
    }

    //получение актуального урла
    public String getActualURL() {
        return driver.getCurrentUrl();

    }

    //проверка страницы яндекса
    public void pushLogoYandex() {
        String originalWindow = driver.getWindowHandle();
        driver.findElement(logoYandex).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.getWindowHandles().size() > 1);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}