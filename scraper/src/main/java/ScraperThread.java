import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class ScraperThread implements Runnable{

    WebData webData;
    ChromeOptions options;
    ChromeDriverService chromeDriverService;



    public ScraperThread(WebData webData, ChromeOptions options, ChromeDriverService chromeDriverService) {
        this.webData = webData;
        this.options = options;
        this.chromeDriverService = chromeDriverService;
    }

    @Override
    public void run() {
        WebDriver driver = new ChromeDriver(chromeDriverService, options);
        driver.get(webData.url);

        /**
         * wait for full load
         */
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * get HP values
         */
        List<WebElement> list = driver.findElements(By.className("ct-health-summary__hp-number"));
        WebElement[] eArr = list.toArray(new WebElement[0]);
        webData.currentHP = Integer.parseInt(eArr[0].getAttribute("innerHTML"));
        webData.maxHP = Integer.parseInt(eArr[1].getAttribute("innerHTML"));

        driver.close();
    }
}
