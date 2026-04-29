package com.automation.stellarai.stellarai_login_automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    @Test
    public void verifyLoginPageElements() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://stellarai.drivetech-ai.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        email.click();
        email.clear();
        email.sendKeys("dtsupport@drivetech-ai.com");

        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        password.click();
        password.clear();
        password.sendKeys("Drivetech123@");

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Sign In']")
        ));
        signInButton.click();
        Thread.sleep(3000);

        assertTrue(driver.getCurrentUrl().contains("stellarai"));

        driver.quit();
    }
}