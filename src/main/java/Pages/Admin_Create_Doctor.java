package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class Admin_Create_Doctor extends TestBase {

	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")
	WebElement doctors;
	
	@FindBy(xpath="//*[@id=\"fullName\"]")
	WebElement name;
	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement email;
	@FindBy(xpath="//*[@id=\"mobileNumber\"]")
	WebElement pnumber;
	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement password;
	@FindBy(xpath="//*[@id=\"confirmPassword\"]")
	WebElement confirmPassword;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-add-doctor-without-license/div/div/div[2]/ng-form-generator/div/div/div/form/input")
	WebElement register;
	@FindBy(xpath="//a[@class=\"mr-2 fa fa-check text-success\"]")
	WebElement approve;
	public Admin_Create_Doctor()
	{
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")));
		doctors.click();
	}
	public void addDoctor(String name1,String emailId,String phoneNumber,String password1) throws InterruptedException
	{
		name.sendKeys(name1);
		Thread.sleep(2000);
		email.sendKeys(emailId);
		pnumber.sendKeys(phoneNumber);
		password.sendKeys(password1);
		confirmPassword.sendKeys(password1);
		Thread.sleep(3000);
		register.click();
		Thread.sleep(5000);
		Home_Admin home=new Home_Admin();
		home.viewDoctorsList("Show All");
		Thread.sleep(6000);
		approve.click();
	}
	
}
