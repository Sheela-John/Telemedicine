package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class Admin_Users extends TestBase {
	
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[3]/a")
	WebElement users;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-users/div/div/div[2]/ng-custom-table/div/div[1]/div[2]/div/input")
	WebElement search;
	@FindBy(xpath="//*[@id=\"action\"]/a")
	WebElement view;
	Home_Doctor doc=new Home_Doctor();
	public Admin_Users()
	{
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[1]/a")));
		users.click();
	}
	public void viewUsersList(String noOfEntry) throws InterruptedException
	{
		Thread.sleep(3000);
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-users/div/div/div[2]/ng-custom-table/div/div[2]/ng-pagination-util/div/div[3]/select")));
		select.selectByVisibleText(noOfEntry);
		List<WebElement> usersList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-users/div/div/div[2]/ng-custom-table/div/div[2]/div/table/tbody/tr"));
		for (int i = 1; i <= usersList.size() - 1; i++) {
			String usersDetails = usersList.get(i).getText();	
			System.out.println("Doctors Details : "+usersDetails);
			
			}
	}
	public void searchuser(String name) throws InterruptedException
	{
		search.sendKeys(name);
		Thread.sleep(2000);
		List<WebElement> usersList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-users/div/div/div[2]/ng-custom-table/div/div[2]/div/table/tbody/tr"));
		for (int i = 1; i <= usersList.size() - 1; i++) {
			String usersDetails = usersList.get(i).getText();	
			System.out.println("Doctors Details : "+usersDetails);
			
			if(usersDetails.contains(name))
			{
				Thread.sleep(3000);
				view.click();
				Thread.sleep(3000);
				doc.viewPersonnalDetails();
				doc.viewMedicalHistory();
				doc.viewLifestyle();
			}
			}
		
	}

}
