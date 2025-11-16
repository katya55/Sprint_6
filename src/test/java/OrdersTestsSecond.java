import POM.AboutRent;
import POM.MainPageHeader;
import POM.MainPageHowThisWork;
import POM.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrdersTestsSecond {

    @RegisterExtension
    static DriverExtension extension = new DriverExtension();

    @BeforeEach
    public void starUp() {
        var driver = extension.getDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void doOrder(String userFirstName, String userLastName, String userAddress, String userPhone, String userComment) {
        WebDriver driver = extension.getDriver();
        MainPageHeader objMainPage = new MainPageHeader(driver);
        objMainPage.closeCookie();

        MainPageHowThisWork objMainPageHowThisWork = new MainPageHowThisWork(driver);
        //клик по заказать(нижней)
        objMainPageHowThisWork.putButtonOrderDown();

        Order objOrder = new Order(driver);

        //проверка появления страницы
        assertTrue(objOrder.isPageOpenPageForScooter(), "Страница заказа самоката не открылась");

        //выбор метро
        objOrder.chooseRandomStation();

        //заполнение полей на странице "кому самокат"
        objOrder.setInputOrder(userFirstName, userLastName, userAddress, userPhone);

        //клик по кнопке далее
        objOrder.putContinue();

        //проверка окна про аренду
        AboutRent objAboutRent = new AboutRent(driver);

        objAboutRent.isPageAboutRent();
        objAboutRent.setDate();
        objAboutRent.setTimeOfRent();
        objAboutRent.setColor();
        objAboutRent.setComment(userComment);
        objAboutRent.putButtonOrder();

        //Модальное окно "вы хотите сделать заказ?"
        assertTrue(objAboutRent.isDoYouWantDoOder(), "Модальное окно заказа не появилось");
        objAboutRent.putYes();
        objAboutRent.checkOrder();

    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("Иван", "Иванов", "Тюмень, Ленина 9", "89101112233", "Позвоните, как приедете"),
                Arguments.of("Петр", "Петров", "Москва, Тверская 123", "79101112233", "Не звоните")
        );
    }
}
