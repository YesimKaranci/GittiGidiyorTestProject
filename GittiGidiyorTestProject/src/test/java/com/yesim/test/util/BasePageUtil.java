package com.yesim.test.util;

import com.yesim.test.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePageUtil {

    public WebDriver driver = BaseTest.getDriver();
    public WebDriverWait wait = BaseTest.getWait();

    public void click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }
    public WebElement findElement(By by){

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    public void doubleClick(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        Actions act = new Actions(driver);
        act.doubleClick().perform();
    }
    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public void hoverElement(By by){

        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public String getText(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return findElement(by).getText();
    }

    public String getAttribute(By by,String text)  {

        return findElement(by).getAttribute(text);
    }

    public boolean isElementDisplayed(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return findElement(by).isDisplayed();
    }

    public boolean isEnabled(By by) {

        return  findElement(by).isEnabled();
    }

    public void keyENTER(By by){

        driver.findElement(by).sendKeys(Keys.ENTER);
   }

    public void thread(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


