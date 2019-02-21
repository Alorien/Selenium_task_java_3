package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class SendAppPage extends BasePage{

    @FindBy(xpath = "//h2[@class='l-header-title ng-binding']")
    public WebElement title;
    @FindBy(name = "insured0_surname")
    WebElement insured0_surname;
    @FindBy(name = "insured0_name")
    WebElement insured0_name;
    @FindBy(name = "insured0_birthDate")
    WebElement insured0_birthDate;
    @FindBy(name = "surname")
    WebElement surname;
    @FindBy(name = "name")
    WebElement name;
    @FindBy(name = "middlename")
    WebElement middlename;
    @FindBy(name = "birthDate")
    WebElement birthDate;
    @FindBy(name = "male")
    WebElement male;
    @FindBy(name = "passport_series")
    WebElement passport_series;
    @FindBy(name = "passport_number")
    WebElement passport_number;
    @FindBy(name = "issuePlace")
    WebElement issuePlace;
    @FindBy(name = "issueDate")
    WebElement issueDate;


    @FindBy(xpath = "//span[@ng-click='save()' and contains(text(),'Продолжить')]")
    public WebElement sendButton;

    public SendAppPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        (new WebDriverWait(BaseSteps.getDriver(), 10))
                .until(ExpectedConditions.visibilityOf(title));
    }
    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Фамилия Загранпаспорта":
                fillField(insured0_surname, value);
                break;
            case  "Имя Загранпаспорта":
                fillField(insured0_name, value);
                break;
            case  "Дата рождения в загранпаспорте":
                fillField(insured0_birthDate, value);
                break;
            case  "Фамилия":
                fillField(surname, value);
                break;
            case  "Имя":
                fillField(name, value);
                break;
            case  "Отчество":
                fillField(middlename, value);
                break;
            case  "Дата рождения":
                fillField(birthDate, value);
                break;
            case  "Пол":
                BaseSteps.getDriver().findElement(By.name("male")).sendKeys("0");
                break;
            case  "Серия паспорта":
                fillField(passport_series, value);
                break;
            case  "Номер паспорта":
                fillField(passport_number, value);
                break;
            case  "Орган выдавший паспорт":
                fillField(issuePlace, value);
                break;
            case  "Дата выдачи":
                fillField(issueDate, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Фамилия Загранпаспорта":
                return insured0_surname.getAttribute("value");
            case  "Имя Загранпаспорта":
                return insured0_name.getAttribute("value");
            case  "Дата рождения в загранпаспорте":
                return insured0_birthDate.getAttribute("value");
            case  "Фамилия":
                return surname.getAttribute("value");
            case  "Имя":
                return name.getAttribute("value");
            case  "Отчество":
                return middlename.getAttribute("value");
            case  "Дата рождения":
                return birthDate.getAttribute("value");
            case  "Пол":
                return male.getAttribute("value");
            case  "Серия паспорта":
                return passport_series.getAttribute("value");
            case  "Номер паспорта":
                return passport_number.getAttribute("value");
            case  "Орган выдавший паспорт":
                return issuePlace.getAttribute("value");
            case  "Дата выдачи":
                return issueDate.getAttribute("value");
        }
        throw new AssertionError("Поле "+fieldName+" не объявлено на странице");
    }


    public void checkFieldErrorMessage(String errorMessage){
        String xpath = "//div[@ng-show='tryNext && myForm.$invalid']";
        String actualValue = BaseSteps.getDriver().findElement(By.xpath(xpath)).getText();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }
    public void sendAppBtn(){
        sendButton.click();
    }
}