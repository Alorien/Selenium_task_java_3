package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageSteps {



    @Step("Нажатие на кнопку: {0}")
    public void selectMenuItem(String menuItem){
        new MainPage().selectMenuItem(menuItem);
    }

    @Step("Нажатие на кнопку: {0}")
    public void selectInsuranceItem(String menuItem){
        new MainPage().selectInsuranceItem(menuItem);
    }

}