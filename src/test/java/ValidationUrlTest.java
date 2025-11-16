import POM.MainPageBlockOfQuestions;
import POM.MainPageHeader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static POM.EnvConfig.URL_OF_SCOOTER;
import static POM.EnvConfig.URL_OF_YANDEX;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationUrlTest {

    @BeforeEach
    public void starUp() {
        var driver = extension.getDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPageHeader objMainPage = new MainPageHeader(driver);
        objMainPage.closeCookie();
        MainPageBlockOfQuestions objBlockOfQuestions = new MainPageBlockOfQuestions(driver);
        objBlockOfQuestions.scroll();
    }

    @RegisterExtension
    private DriverExtension extension = new DriverExtension();

    @Test
    public void checkOpenPageOfScooterAfterPushLogo(){
        var driver = extension.getDriver();
        MainPageHeader obgMainPageHeader = new MainPageHeader(driver);
        obgMainPageHeader.pushLogoScooter();
        String actualUrl = obgMainPageHeader.getActualURL();
        assertEquals(URL_OF_SCOOTER, actualUrl, "URL не совпадает");
    }

    @Test
    public void checkOpenPageOfYandexAfterPushLogo(){
        var driver = extension.getDriver();
        MainPageHeader obgMainPageHeader = new MainPageHeader(driver);
        obgMainPageHeader.pushLogoYandex();
        String actualUrl = obgMainPageHeader.getActualURL();
        assertEquals(URL_OF_YANDEX, actualUrl, "URL не совпадает");
    }


}
