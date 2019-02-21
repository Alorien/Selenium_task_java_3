package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;


public class MainPage{

    @FindBy(xpath = "//div[@class='lg-menu']")
    WebElement menuItems;



    public MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenuItem(String itemName){
        menuItems.findElement(By.xpath(".//span[contains(text(),'"+itemName+"')]")).click();
    }

    public void selectInsuranceItem(String itemName){
        BaseSteps.getDriver().findElement(By.xpath("//a[@class='lg-menu__sub-link'][contains(text(),'"+itemName+"')]")).click();

    }

}