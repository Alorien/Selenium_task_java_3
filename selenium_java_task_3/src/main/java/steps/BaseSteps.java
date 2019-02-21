package steps;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    private static WebDriver driver;
    protected static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();
    public static WebDriver getDriver(){
        return driver;
    }

    @Before
    public void startScenario(){
        System.setProperty("webdriver.chrome.driver", "drx/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = properties.getProperty("app.url");
        driver.get(baseUrl + "/");
        driver .manage().window().maximize();
        driver .manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver .manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void afterMethod(){
        driver .quit();
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}