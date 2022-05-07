import org.apache.commons.io.output.NullOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.service.DriverService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

public class WebSim {
    ChromeOptions options;
    DriverService.Builder<ChromeDriverService, ChromeDriverService.Builder> serviceBuilder;
    ChromeDriverService chromeDriverService;
    public WebSim(){
        System.setProperty("webdriver.chrome.driver", "D:\\libs\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        serviceBuilder = new ChromeDriverService.Builder();
        chromeDriverService = serviceBuilder.build();
        chromeDriverService.sendOutputTo(NullOutputStream.NULL_OUTPUT_STREAM);

        options = new ChromeOptions();
        options.addArguments("--silent");
        options.addArguments("--log-level=3");
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }

    private void test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.dndbeyond.com/characters/52238149");
        System.out.println("initiated load");
        try {
            Thread.sleep(Long.parseLong("1500"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement currentHP = driver.findElement(By.className("ct-health-summary__hp-number"));
        System.out.println("element loaded");

        System.out.println(currentHP.getAttribute("innerHTML"));
        driver.close();
    }

    public void getData(ArrayList<WebData> list){
        List<Thread> threadList = new LinkedList<>();
        for (WebData webData : list){
            ScraperThread st = new ScraperThread(webData, options, chromeDriverService);
            threadList.add(new Thread(st));
        }for (Thread thread : threadList){
            thread.start();
        }for (Thread thread : threadList){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
