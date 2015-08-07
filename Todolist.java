package edu.ucsc.extension;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.Console;

public class Todolist {

	@Test
	public void sortNumbers() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file://" + System.getProperty("user.dir") + File.separator + "html" + File.separator + "todolist.html");
		
		WebElement thing = driver.findElement(By.name("things"));
		WebElement add = driver.findElement(By.name("add"));
		Actions build = new Actions(driver);
		build.click(thing).sendKeys("").click(add).perform();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("warning")));
	    
		Util.wait(3);
		driver.quit();	

}
}