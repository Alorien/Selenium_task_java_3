package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.ArrayList;
;


public class MinInsurationPage{




    public MinInsurationPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
        //Получение массива вкладок
        ArrayList<String> tabs = new ArrayList<String> (BaseSteps.getDriver().getWindowHandles());
        //Переход на новую вкладку
        BaseSteps.getDriver().switchTo().window(tabs.get(1));
    }
    public void selectMinIsuration(String itemName){
        BaseSteps.getDriver().findElement(By.xpath("//div[contains(text(),'"+itemName+"')]")).click();
    }
    public void selectRegItem(String itemName){
        BaseSteps.getDriver().findElement(By.xpath("//span[@ng-click='save()' and contains(text(),'"+itemName+"')]")).click();
    }



}