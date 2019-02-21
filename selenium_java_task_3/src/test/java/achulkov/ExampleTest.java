package achulkov;

import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class ExampleTest extends BaseSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    InsurationPageSteps insurationPageStepsPageSteps = new InsurationPageSteps();
    MinInsurationPageSteps minInsurationPageSteps = new MinInsurationPageSteps();
    SendAppPageSteps sendAppPageSteps = new SendAppPageSteps();

    HashMap<String, String> testData = new HashMap<>();

    @Title("Оформление кредита на путешествия и покупки")
    @Test
    public void Test() {
        testData.put("Фамилия Загранпаспорта","Ivanov");
        testData.put("Имя Загранпаспорта","Ivan");
        testData.put("Дата рождения в загранпаспорте","11.02.2019");
        testData.put("Фамилия","Иванов");
        testData.put("Имя","Иван");
        testData.put("Отчество","Иванович");
        testData.put("Дата рождения","01.02.1990");
        testData.put("Пол","0");
        testData.put("Серия паспорта","1111");
        testData.put("Номер паспорта","111111");
        testData.put("Орган выдавший паспорт","ТП №1 по г. Москва");
        testData.put("Дата выдачи","15.02.2008");

        mainPageSteps.selectMenuItem("Страхование");
        mainPageSteps.selectInsuranceItem("Путешествия и покупки");
        insurationPageStepsPageSteps.checkTextPage("Страхование путешественнико");
        insurationPageStepsPageSteps.clickBtnRegOnline("Оформить онлайн");
        minInsurationPageSteps.selectMinIsuration("Минимальная");
        minInsurationPageSteps.selectRegItem("Оформить");
        sendAppPageSteps.fillFields(testData);
        sendAppPageSteps.checkFillFields(testData);
        sendAppPageSteps.btnSendApp("Продолжить");
        sendAppPageSteps.checkErrorMessageField("Заполнены не все обязательные поля");

    }
}
