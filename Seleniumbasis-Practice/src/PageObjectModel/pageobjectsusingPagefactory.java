package PageObjectModel;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class pageobjectsusingPagefactory {
	
@FindBy(id="twotabsearchtextbox")
public static WebElement searchbox;


@FindBy(className="nav-input")
public static WebElement searchbutton;
	

@FindBy(xpath="//*[@id=\"p_85/15602504031\"]/span/a/div/label/i")
public static WebElement amazonfilter;
	

@FindBy(xpath="//li[@id='p_n_feature_nine_browse-bin/15412929031']//i[@class='a-icon a-icon-checkbox']")
public static WebElement language;
	

@FindBy(xpath="//span[contains(text(),'The Sheikh CEO - Lessons in Leadership from Mohamm')]")
public static WebElement book;


}
