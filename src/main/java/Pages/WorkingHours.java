package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class WorkingHours extends TestBase{
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[6]/a")
	WebElement WorkingHours;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-working-hours/div[1]/div[2]/div/div/div[1]/div[1]/div/div/input")
	WebElement enableDisable;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-working-hours/div[1]/div[2]/div/div/div[2]/div/div/div[2]/form/div[1]/div[1]/input")
	WebElement startTime;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-working-hours/div[1]/div[2]/div/div/div[2]/div/div/div[2]/form/div[1]/div[2]/input")
	WebElement endTime;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-my-medications/div[2]/div/div/div[3]/button[1]")
	WebElement createSession;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-working-hours/div[1]/div[2]/div/div/div[2]/div/div/div[2]/form/div[2]")
	WebElement temp;
	 public WorkingHours() {
		PageFactory.initElements(driver, this);
	}
	public void viewWorkingHours()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[6]/a")));
		WorkingHours.click();
	}
	public void SetDayValue(String day) throws InterruptedException
	{
		Thread.sleep(3000);
		 List<WebElement> DayList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-working-hours/div[1]/div[2]/nav/div/a"));
			for (int j = 0; j <= DayList.size() - 1; j++) {	
				String details = DayList.get(j).getText();
				 if (details.contains(day))
				 {
						DayList.get(j).click();
						Thread.sleep(7000);
						break;
				}
		}
		 
	}
	public void toEnabletheDay(String strTime,String eTime) throws InterruptedException {
	
		System.out.println(enableDisable.isEnabled());
		if(!enableDisable.isEnabled()) {
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-working-hours/div[1]/div[2]/div/div/div[1]/div[1]/div/div/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-working-hours/div[1]/div[2]/div/div/div[1]/div[1]/div/div/input")));
		  }
		
		Thread.sleep(3000);
		try{
			     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-working-hours/div[1]/div[2]/div/div/div[1]/div[2]/button")).click();
			  } catch (Exception e) {
			     JavascriptExecutor executor = (JavascriptExecutor) driver;
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-working-hours/div[1]/div[2]/div/div/div[1]/div[2]/button")));
			  }
			Thread.sleep(8000);
			startTime.sendKeys(strTime);
			Thread.sleep(4000);
			System.out.println("Start");
		
			endTime.sendKeys(eTime);
			System.out.println("end");
			Thread.sleep(5000);
		}
	
	else
	{
		try{
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-working-hours/div[1]/div[2]/div/div/div[1]/div[2]/button")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-working-hours/div[1]/div[2]/div/div/div[1]/div[2]/button")));
		  }
		Thread.sleep(8000);
		startTime.sendKeys(strTime);
		Thread.sleep(4000);
		System.out.println("Start");
		Thread.sleep(5000);
		endTime.sendKeys(eTime);
		System.out.println("end");
		Thread.sleep(5000);
	}
	}
}
