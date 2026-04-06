package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;


public class login {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\brave.exe");
        WebDriver driver = new ChromeDriver(options);

        try{
            String baseUrl = "https://demo.guru99.com/test/newtours/";
            driver.get(baseUrl);

            WebElement registerLink = driver.findElement(By.xpath("//a[normalize-space()='REGISTER']"));
            registerLink.click();

            String firstname = "Carlos";
            String lastname = "Hernandez";
            String phoneNumber = "123456789";
            String email = "carlos@test.com";
            String address = "Principal av 554";
            String city = "Berlin";
            String state = "Koln";
            String zipCode = "12345";
            String country = "MEXICO";
            String username = "chf";
            String password = "chf1234";
            String confirmPassword = "chf1234";

            driver.findElement(By.name("firstname")).sendKeys(firstname);
            driver.findElement(By.name("lastname")).sendKeys(lastname);
            driver.findElement(By.name("phone")).sendKeys(phoneNumber);
            driver.findElement(By.name("userName")).sendKeys(email);
            driver.findElement(By.name("address1")).sendKeys(address);
            driver.findElement(By.name("city")).sendKeys(city);
            driver.findElement(By.name("state")).sendKeys(state);
            driver.findElement(By.name("postalCode")).sendKeys(zipCode);
            Select countryCode = new Select(driver.findElement(By.name("country")));
            countryCode.selectByVisibleText(country);
            driver.findElement(By.name("email")).sendKeys(username);
            driver.findElement(By.name("password")).sendKeys(password);
            driver.findElement(By.name("confirmPassword")).sendKeys(confirmPassword);

            driver.findElement(By.name("submit")).click();

            System.out.println("Registro exitoso");

            driver.get(baseUrl);

            WebElement userField = driver.findElement(By.name("userName"));
            userField.sendKeys(username);
            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys(password);
            WebElement submitButton = driver.findElement(By.name("submit"));
            submitButton.click();

        }
        catch (Exception e){
            System.err.println("Error durante la automatización");
            e.printStackTrace(System.err);

        }

    }

}
