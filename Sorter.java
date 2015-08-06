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

import com.gargoylesoftware.htmlunit.javascript.host.Console;

public class Sorter {

	@Test
	public void sortNumbers() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file://" + System.getProperty("user.dir") + File.separator + "html" + File.separator + "sorter.html");
		List<WebElement> list = driver.findElements(By.tagName("li"));
		
		int largestnum =10;
		
		do {
		
	    WebElement largest = list.get(0);
		int order =0;			
		for (int i=0; i<list.size();i++){
			int number = Integer.parseInt(list.get(i).getText());
		    if(number == largestnum){
		    	largest = list.get(i);  
		    }
		}
		Actions build = new Actions(driver);
		build.clickAndHold(largest).moveByOffset(0,-1*(largest.getLocation().y)).release(largest);
		build.perform();
		
		Util.wait(1);
		largestnum = largestnum-1;
		
		
		
		
	}while (largestnum > 0);

		Util.wait(10);
		driver.quit();	

}
}