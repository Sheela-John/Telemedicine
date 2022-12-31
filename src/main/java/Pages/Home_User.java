package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class Home_User extends TestBase {

	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[3]/a")
	WebElement provider;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-doctors/div/div/div[2]/div[1]/div/div/input")
	WebElement search;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-doctors/div/div/div[2]/div[3]/div/div/div/div/div[2]/div/h5[1]")
	WebElement docname;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-doctors/div/div/div[2]/div[3]/div/div[1]/div/div/div[3]/div/button")
	WebElement bookAppointment; 
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-doctors/div[1]/div[2]/div/div/div[2]/div/div[1]/div[1]/button")
	WebElement online;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-doctors/div[1]/div[2]/div/div/div[2]/div/div[1]/div[2]/button")
	WebElement inClinic;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-doctors/div[1]/div[2]/div/div/div[2]/div/div[2]/div[1]/span")
	WebElement dateText;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-doctors/div[1]/div[2]/div/div/div[2]/div/div[2]/div[1]/a[2]")
	WebElement nextDate;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-doctors/div[3]/div/div/div[2]/form/div/div[4]/div/input")
	WebElement reason;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-doctors/div[3]/div/div/div[3]/button[1]")
	WebElement booknow;
	@FindBy(xpath="//div[@class='badge_position']")
	WebElement status;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-payment/div[1]/div[2]/div/div/div[7]/div/button")
	WebElement payandBook;
	
	public Home_User() {
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[3]/a")));
		provider.click();
	}
	public void viewSearchProviders() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> providersList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-doctors/div/div/div[2]/div[3]"));
		System.out.println(providersList.size());
		for (int i = 0; i <= providersList.size() - 1; i++) {
			System.out.println(providersList.get(i).getText());
		}
	}
	public String searchProvider(String name) throws InterruptedException
	{
		Thread.sleep(5000);
		search.click();
		Thread.sleep(3000);
		search.sendKeys(name);
		Thread.sleep(2000);
		String dname=docname.getText();
		String message="";
		if(dname.contains(name))
		{
			message="Doctor Available";
			return message;
		}
		
			return message;
		
		
	}
	public void toSelectDateAndTime(String date,String time,String reasonforappointment) throws InterruptedException
	{
		for(int i=0;i<10;i++)
		{
		String val=dateText.getText();
		if(val.equals(date)) {
			String details="";
			List<WebElement> SlotList = driver.findElements(By.cssSelector("#individualSlot"));
			
			for (int j = 0; j < SlotList.size() - 1; j++) {
				try
				{
					details=SlotList.get(j).getText();
				}
				catch(StaleElementReferenceException e)
				{
					details=SlotList.get(j).getText();
				}
			if(details.contains(time))
			{
			
				
				try {
					if(details.contains("Booked"))
					{
						System.out.println("Its already Booked please Book another slot");
						break;
					}
					else
					{
						SlotList.get(j).click();
						Thread.sleep(3000);
						reason.sendKeys(reasonforappointment);
						Thread.sleep(3000);
						booknow.click();
						Thread.sleep(2000);
						payandBook.click();
						Thread.sleep(2000);
						break;
					}
				}
				catch(StaleElementReferenceException e)
				{
					SlotList = driver.findElements(By.cssSelector("#individualSlot"));
					SlotList.get(j).click();
					Thread.sleep(3000);
					reason.sendKeys(reasonforappointment);
					Thread.sleep(3000);
					booknow.click();
					Thread.sleep(2000);
					payandBook.click();
					Thread.sleep(2000);
					break;
				}
				
				
			}
			}
			break;
		}
		else
		{
			nextDate.click();	
		}
		}
		
	}
	public void toBookAppointment(String name,String method,String date,String time,String reasonfor) throws InterruptedException
	{
		Thread.sleep(3000);
		String msg=searchProvider(name);
		if(msg.equals("Doctor Available"))
		{
			bookAppointment.click();
			if(method.equals("Online"))
			{Thread.sleep(3000);
				online.click();
				Thread.sleep(3000);
				toSelectDateAndTime(date,time,reasonfor);
			}
			else if(method.equals("In clinic"))
			{
				inClinic.click();
				Thread.sleep(3000);
				toSelectDateAndTime(date,time,reasonfor);
			}
			Thread.sleep(3000);
		}
	}
	
}
