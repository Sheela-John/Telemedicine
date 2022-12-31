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

public class MyAppointments extends TestBase {
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[4]/a")
	WebElement myAppointments;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[1]/a")
	WebElement back;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/div/div[1]/div[1]/div[1]")
	WebElement appdetails;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/nav/div/a[2]")
	WebElement paymentDetails;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/div/div[2]/div")
	WebElement pay;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/nav/div/a[3]")
	WebElement medication;
	public MyAppointments() {
	
	PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[4]/a")));
		myAppointments.click();
	}
	public void viewAppointmentDetails(String status) throws InterruptedException
	{
		//Select select = new Select(driver.findElement(By.xpath("//html/body/app-dashboard/div/main/div[2]/app-user-appointments/div/div[2]/div[1]/div/div[2]/select")));
		//select.selectByVisibleText(status);
		//Thread.sleep(6000);
		List<WebElement> consultationsList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-user-appointments/div/div[2]/div[2]/div"));
		for (int i = 0; i <= consultationsList.size() - 1; i++) {
			consultationsList.get(i).click();
			Thread.sleep(6000);
			viewAppointmentDetails();
			viewPaymentDetails();
			//back.click();
		}
	}
	public void viewAppointmentDetails()
	{
		System.out.println(appdetails.getText());
	}
	public void viewPaymentDetails()
	{
		paymentDetails.click();
		System.out.println(pay.getText());
	}
	public void viewMedicationDetails()
	{
		
	}

}
