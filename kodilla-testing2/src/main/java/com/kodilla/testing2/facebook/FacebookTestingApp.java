package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookTestingApp {

    public static final String XPATH_BUTTON_ACCEPT_COOKIES = "//button[@data-testid='cookie-policy-dialog-accept-button']";
    public static final String XPATH_BUTTON_NEW_ACCOUNT = "//div[@class='_6ltg']/a[@data-testid='open-registration-form-button']";
    public static final String XPATH_INPUT_NAME =  "//div[@class='_n8 _3qx _8idq _8esf _8f3m _8fgk uiLayer _3qw']/div/div/div/div/div/div/div/form/div/div/div/div/div/input[@name='firstname']";
    public static final String XPATH_INPUT_SURNAME =  "//input[@name='lastname']";
    public static final String XPATH_INPUT_CONTACT =  "//input[@name='reg_email__']";
    public static final String XPATH_INPUT_PASSWORD =  "//input[@name='reg_passwd__']";
    public static final String XPATH_SELECT_DAY =  "//select[@name='birthday_day']";
    public static final String XPATH_SELECT_MONTH =  "//select[@name='birthday_month']";
    public static final String XPATH_SELECT_YEAR =  "//select[@name='birthday_year']";
    public static final String XPATH_SELECT_MALE =  "//div[@class='_n8 _3qx _8idq _8esf _8f3m _8fgk uiLayer _3qw']/div/div/div/div/div/div/div/form/div/div/span/span/input[@value='2']";

    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://facebook.com/");

        WebDriverWait wait = new WebDriverWait(driver, 3);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_BUTTON_ACCEPT_COOKIES))).click();

        driver.findElement(By.xpath(XPATH_BUTTON_NEW_ACCOUNT)).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_INPUT_NAME))).sendKeys("Karol");
        driver.findElement(By.xpath(XPATH_INPUT_SURNAME)).sendKeys("Krawczyk");
        driver.findElement(By.xpath(XPATH_INPUT_CONTACT)).sendKeys("555666777");
        driver.findElement(By.xpath(XPATH_INPUT_PASSWORD)).sendKeys("password");

        Select select = new Select(driver.findElement(By.xpath(XPATH_SELECT_DAY)));
        select.selectByValue("13");

        select = new Select(driver.findElement(By.xpath(XPATH_SELECT_MONTH)));
        select.selectByIndex(3);

        select = new Select(driver.findElement(By.xpath(XPATH_SELECT_YEAR)));
        select.selectByValue("1999");

        driver.findElement(By.xpath(XPATH_SELECT_MALE)).click();
    }
}
