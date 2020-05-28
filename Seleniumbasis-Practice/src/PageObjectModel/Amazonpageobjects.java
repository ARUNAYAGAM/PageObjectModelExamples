package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Amazonpageobjects {
	
	public static WebElement searchbox(WebDriver driver) {
		
		return driver.findElement(By.id("twotabsearchtextbox"));
	}

	public static WebElement searchbutton(WebDriver driver) {
		
		return driver.findElement(By.className("nav-input"));
	}
	
	public static WebElement amazonfilter(WebDriver driver) {
		
		return driver.findElement(By.xpath("//*[@id=\"p_85/15602504031\"]/span/a/div/label/i"));
	}
	
	public static WebElement language(WebDriver driver) {
		
		return driver.findElement(By.xpath("//li[@id='p_n_feature_nine_browse-bin/15412929031']//i[@class='a-icon a-icon-checkbox']"));
	}
	
	public static WebElement book(WebDriver driver) {
		
		return driver.findElement(By.xpath("//span[contains(text(),'The Sheikh CEO - Lessons in Leadership from Mohamm')]"));
	}
}
