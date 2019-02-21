package steps;
import pages.InsurationPage;
import ru.yandex.qatools.allure.annotations.Step;
public class InsurationPageSteps {
    @Step("Проверка наличии текста: {0}")
    public void checkTextPage(String menuItem){
        new InsurationPage().checkTextPage(menuItem);
    }
    @Step("Нажатие кнопки: {0}")
    public void clickBtnRegOnline(String menuItem){
        new InsurationPage().clickBtnRegOnline(menuItem);
    }
}
