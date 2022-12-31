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

public class Home_Admin extends TestBase {
	
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[1]/a")
	WebElement doctors_List;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-all-doctors/div[1]/div/div[2]/ng-custom-table/div/div[1]/div[2]/div/input")
	WebElement search;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-all-doctors/div[1]/div/div[2]/ng-custom-table/div/div[2]/div/table/tbody/tr[2]/td[5]/a")
	WebElement delete;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-all-doctors/div[2]/div/div/div[3]/button[1]")
	WebElement deleteConfirm;
	
	public Home_Admin()
	{
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[1]/a")));
		doctors_List.click();
	}
	public void viewDoctorsList(String noOfEntry)
	{
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-all-doctors/div[1]/div/div[2]/ng-custom-table/div/div[2]/ng-pagination-util/div/div[3]/select")));
		select.selectByVisibleText(noOfEntry);
		List<WebElement> doctorsList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-all-doctors/div[1]/div/div[2]/ng-custom-table/div/div[2]/div/table/tbody/tr"));
		for (int i = 1; i <= doctorsList.size() - 1; i++) {
			String doctorsDetails = doctorsList.get(i).getText();
			System.out.println("Doctors Details : "+doctorsDetails);
			}
	}
	public void searchDoctor(String name) throws InterruptedException
	{
		search.sendKeys(name);
		Thread.sleep(2000);
		List<WebElement> doctorsList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-all-doctors/div[1]/div/div[2]/ng-custom-table/div/div[2]/div/table/tbody/tr"));
		for (int i = 1; i <= doctorsList.size() - 1; i++) {
			String doctorsDetails = doctorsList.get(i).getText();
			System.out.println("Doctors Details : "+doctorsDetails);
			}
		
	}
	public void deleteDoctor(String name)throws InterruptedException
	{
		searchDoctor(name);
		Thread.sleep(2000);
		delete.click();
		Thread.sleep(3000);
		deleteConfirm.click();
	}
	}


