package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class ProfileUser extends TestBase {
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")
	WebElement profile;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div[1]/div[1]/div[1]/input")
	WebElement name;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div[1]/div[2]/div[1]/div/div[1]")
	WebElement male;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div[1]/div[2]/div[1]/div/div[2]")
	WebElement female;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div[1]/div[2]/div[1]/div/div[3]")
	WebElement others;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/input")
	WebElement heightFeet;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/input")
	WebElement heightInch;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div[2]/div[2]/div[1]/div/input")
	WebElement weight;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div[3]/div[1]/div[1]/input")
	WebElement dateOfBirth;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div[4]/div/input")
	WebElement location;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div[1]/div/div[1]/tag-input/div/div/tag-input-form/form/input")
	WebElement currentMedic;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div[2]/div/div[1]/tag-input/div/div/tag-input-form/form/input")
	WebElement pastMedic;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div[3]/div/div[1]/tag-input/div/div/tag-input-form/form/input")
	WebElement surgeries;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div[4]/div/div[1]/tag-input/div/div/tag-input-form/form/input")
	WebElement chronicDisease;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div[5]/div/div[1]/tag-input/div/div/tag-input-form/form/input")
	WebElement injuries;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div[6]/div/div[1]/tag-input/div/div/tag-input-form/form/input")
	WebElement allergies;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div[1]/div[1]/div[1]/tag-input/div/div/tag-input-form/form/input")
	WebElement diet;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div[1]/div[2]/div/div[1]/input")
	WebElement smokeyes;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div[1]/div[2]/div/div[2]/input")
	WebElement smokeNo;
	@FindBy(xpath="//*[@id=\"AlcoholRadio1\"]")
	WebElement alcoholyes;
	@FindBy(xpath="//*[@id=\"AlcoholRadio2\"]")
	WebElement alcoholno;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[4]/div/button")
	WebElement save;
	
	public ProfileUser()
	{
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[3]/a")));
		profile.click();
	}
	public void editProfile(String name1,String gender1,String heightFeet1,String heightInch1,String weight1,String date1,String blood,String location1,String currMedic,String pastmedic1,String surgeries1,String chronic, String injuries1,String allergies1,String diet1,String smoke,String alcohol,String activity) throws InterruptedException
	{
		name.clear();
		name.sendKeys(name1);
		Thread.sleep(3000);
		if(gender1.equals("Male"))
		{
			male.click();
		}
		else if(gender1.equals("Female"))
		{
			female.click();
		}
		else
		{
			others.click();
		}
		Thread.sleep(3000);
		heightFeet.clear();
		heightFeet.sendKeys(heightFeet1);
		Thread.sleep(3000);
		heightInch.clear();
		heightInch.sendKeys(heightInch1);
		Thread.sleep(3000);
		weight.clear();
		weight.sendKeys(weight1);
		Thread.sleep(3000);
		dateOfBirth.clear();
		dateOfBirth.sendKeys(date1);
		Thread.sleep(3000);
		
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div[3]/div[2]/div[1]/select")));
		select.selectByVisibleText(blood);
		Thread.sleep(3000);
		location.clear();
		location.sendKeys(location1);
		Thread.sleep(3000);
		currentMedic.clear();
		currentMedic.sendKeys(currMedic);
		Thread.sleep(3000);
		pastMedic.clear();
		pastMedic.sendKeys(pastmedic1);
		Thread.sleep(3000);
		surgeries.clear();
		surgeries.sendKeys(surgeries1);
		Thread.sleep(3000);
		chronicDisease.clear();
		chronicDisease.sendKeys(chronic);
		Thread.sleep(3000);
		injuries.clear();
		injuries.sendKeys(injuries1);
		Thread.sleep(3000);
		allergies.clear();
		allergies.sendKeys(allergies1);
		Thread.sleep(3000);
		diet.clear();
		diet.sendKeys(diet1);
		Thread.sleep(6000);
		if(smoke.equals("Yes"))
		{
			try {
			     driver.findElement(By.linkText("Scans")).click();
			  } catch (Exception e) {
			     JavascriptExecutor executor = (JavascriptExecutor) driver;
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div[1]/div[2]/div/div[1]/input")));
			  }
		}
		else
		{
			try {
			     driver.findElement(By.linkText("Scans")).click();
			  } catch (Exception e) {
			     JavascriptExecutor executor = (JavascriptExecutor) driver;
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div[2]/div[1]/div[1]/div/div[2]/input")));
			  }
		}
		if(alcohol.equals("yes"))
		{
			try {
			     driver.findElement(By.linkText("Scans")).click();
			  } catch (Exception e) {
			     JavascriptExecutor executor = (JavascriptExecutor) driver;
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div[2]/div[1]/div[1]/div/div[1]/input")));
			  }
			
		}
		else
		{
			try {
			     driver.findElement(By.linkText("Scans")).click();
			  } catch (Exception e) {
			     JavascriptExecutor executor = (JavascriptExecutor) driver;
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div[2]/div[1]/div[1]/div/div[2]/input")));
			  }
			
		}
		Thread.sleep(3000);
		Select select1 = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-user-profile/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div[2]/div[2]/div[1]/select")));
		select1.selectByVisibleText(activity);
		Thread.sleep(3000);
		save.click();
		
	}

}
