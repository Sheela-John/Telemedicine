package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class UploadPriscription extends TestBase{
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[4]/a/app-sidebar-nav-link-content")
	WebElement Appointments;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/nav/div/a[4]")
	WebElement uploadPrescription;
	@FindBy(xpath="//*[@id=\"customFile\"]")
	WebElement choosefile;
	
	@FindBy(xpath="//*[@id=\"uploadmedication\"]/form/button")
	WebElement upload;
	public UploadPriscription() {
		PageFactory.initElements(driver, this);
	}
	public void viewAppointments()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[4]/a/app-sidebar-nav-link-content")));
		Appointments.click();
	}
	public void uploadPrescription(String filepath) throws InterruptedException
	{
		Thread.sleep(5000);
		uploadPrescription.click();
		Thread.sleep(2000);
		choosefile.sendKeys(filepath);
		Thread.sleep(3000);
		upload.click();
		
	}
}
