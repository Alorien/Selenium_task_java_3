package steps;
import pages.SendAppPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class SendAppPageSteps {
    @Step("Заполнение поля {0} значением {1}}")
    public void fillField(String field, String value){
        new SendAppPage().fillField(field, value);
    }

    @Step("Заполнение поля {0} значением {1}")
    public void checkFillField(String field, String value){
        String actual = new SendAppPage().getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("Проверка на наличие сообщения: ")
    public void checkErrorMessageField(String value){
        new SendAppPage().checkFieldErrorMessage(value);
    }

    @Step("Заполнение полей")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> fillField(k,v));
    }

    @Step("Поля заполнено верно")
    public void checkFillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> checkFillField(k,v));
    }

    @Step("Нажатие кнопки: {0}")
    public void btnSendApp(String nameBtn){
        new SendAppPage().sendAppBtn();
    }
}
