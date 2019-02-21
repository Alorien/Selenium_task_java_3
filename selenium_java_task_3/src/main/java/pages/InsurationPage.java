package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;


public class InsurationPage{

    @FindBy(xpath = "//div[@data-pid = 'SBRF_ColList_sb_bundle-9624889']//a[@href='https://online.sberbankins.ru/store/vzr/index.html']")
    public WebElement buttonRegisterOnline;


    public InsurationPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }


    public void checkTextPage(String textPage){
        String xpath = "//div[@data-pid = 'SBRF-TEXT-1016295']//h3";
        String actualValue = BaseSteps.getDriver().findElement(By.xpath(xpath)).getText();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, textPage),
                actualValue.contains(textPage));
    }
    public  void clickBtnRegOnline(String nameButton){
        buttonRegisterOnline.click();
    }
}