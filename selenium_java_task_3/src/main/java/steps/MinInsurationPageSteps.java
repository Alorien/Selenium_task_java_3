package steps;

import pages.MinInsurationPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MinInsurationPageSteps {
    @Step("Выбор страховки со значением: {0}")
    public void selectMinIsuration(String menuItem){
        new MinInsurationPage().selectMinIsuration(menuItem);
    }

    @Step("Нажатие на кнопку: {0}")
    public void selectRegItem(String menuItem){
        new MinInsurationPage().selectRegItem(menuItem);
    }


}
