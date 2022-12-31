package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class Reports extends TestBase {

	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[7]/a")
	WebElement reports;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-doctor-reports/div/div/div[2]/div[1]/div[1]/input")
	WebElement selectdate;
	@FindBy(xpath="/html/body/bs-daterangepicker-container/div/div[2]/bs-custom-date-view/div/button[1]")
	WebElement last7days;
	@FindBy(xpath="/html/body/bs-daterangepicker-container/div/div[2]/bs-custom-date-view/div/button[2]")
	WebElement thisweek;
	@FindBy(xpath="/html/body/bs-daterangepicker-container/div/div[2]/bs-custom-date-view/div/button[3]")
	WebElement thismonth;
	@FindBy(xpath="/html/body/bs-daterangepicker-container/div/div[2]/bs-custom-date-view/div/button[4]")
	WebElement lastmonth;
	@FindBy(xpath="/html/body/bs-daterangepicker-container/div/div[2]/bs-custom-date-view/div/button[5]")
	WebElement customrange;
	public Reports()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void viewReports() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[7]/a")));
		reports.click();
		Thread.sleep(3000);
	}
	
	public void selectDate(String method,String startDate,String endDate) throws InterruptedException
	{ 
		selectdate.click();
		if(method.contains("Last 7 Days"))
		{
			System.out.println(" Method" +method);
			Thread.sleep(3000);
			last7days.click();
			Thread.sleep(3000);
		}
		else if(method.contains("This Week"))
		{
			System.out.println(" Method" +method);
			Thread.sleep(3000);
			thisweek.click();
			Thread.sleep(3000);
		}
		else if(method.contains("This Month"))
		{
			System.out.println(" Method" +method);
			Thread.sleep(3000);
			thismonth.click();
			Thread.sleep(3000);
		}
		else if(method.contains("Last Month"))
		{
			System.out.println(" Method" +method);
			Thread.sleep(3000);
			lastmonth.click();
			Thread.sleep(3000);
		}
		else if(method.contains("Custome Range"))
		{
		
		Thread.sleep(4000);
	List<WebElement> elements = driver.findElements(By.xpath("/html/body/bs-daterangepicker-container/div/div[1]/div/div/bs-days-calendar-view[1]/bs-calendar-layout/div[2]/table/tbody/tr/td"));
	System.out.println(elements.size());
	for (int i=0; i<elements.size();i++)
	{
		String details =elements.get(i).getText();
		 if (details.equals(startDate))
		 {
			 Thread.sleep(4000);
			 elements.get(i).click();
			 Thread.sleep(4000);
			 System.out.println("StartDate:"+details);
			break;	
		}
}
	 Thread.sleep(4000);
	List<WebElement> elements1 = driver.findElements(By.xpath("/html/body/bs-daterangepicker-container/div/div[1]/div/div/bs-days-calendar-view[1]/bs-calendar-layout/div[2]/table/tbody/tr/td"));
	for (int i=0; i<elements1.size();i++)
	{
		String details =elements1.get(i).getText();
		 if (details.equals(endDate))
		 {
			 Thread.sleep(4000);
			 elements1.get(i).click();
			 Thread.sleep(4000);
			 System.out.println("EndDate:"+details);
			break;	
		}
}
		}
		else
		{
			System.out.println("Not Matched Method");
		}
	}
}
