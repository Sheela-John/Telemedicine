package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class Appointments extends TestBase {
	String details="";
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[4]/a/app-sidebar-nav-link-content")
	WebElement Appointments;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointments/div/div[2]/div[2]/div/div[1]/div/div/div/div")
	WebElement view;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/nav/div/a[2]")
	WebElement paymentDetails;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/nav/div/a[3]")
	WebElement medication;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/nav/div/a[4]")
	WebElement uploadPrescription;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/nav/div/a[5]")
	WebElement testLabs;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/nav/div/a[6]")
	WebElement treatment;
	@FindBy(xpath="//*[@id=\"customFile\"]")
	WebElement choosefile;
	@FindBy(xpath="//*[@id=\"uploadmedication\"]/form/button")
	WebElement upload;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/div/div[6]/div/div/div/div[1]/button")
	WebElement addTestLab;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/div/div[6]/div/div/div/form/div[2]/div[1]/div[2]/button")
	WebElement addTests;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/div/div[6]/div/div/div/form/div[1]/div/div/input")
	WebElement labName;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/div/div[6]/div/div/div/form/div[2]/div[2]/div[1]/input")
	WebElement testName;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/div/div[6]/div/div/div/form/button")
	WebElement addLabTests;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/div/div[7]/div/div/div/div/div/button")
	WebElement addNewTreatment;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/div/div[7]/div/div/div/form/div[2]/div/div/div[1]/input")
	WebElement treatmentName;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/div/div[7]/div/div/div/form/div[2]/div/div/div[2]/input")
	WebElement amount;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/div/div[7]/div/div/div/form/div[2]/button")
	WebElement saveTreatment;
	public Appointments() {
		PageFactory.initElements(driver, this);
	}
	public void viewAppointments()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[4]/a/app-sidebar-nav-link-content")));
		Appointments.click();
	}
	public static String removeLastChar(String str) {
	    return removeLastChars(str, 1);
	}

	public static String removeLastChars(String str, int chars) {
	    return str.substring(0, str.length() - chars);
	}
	public void viewAllAppointments(String date,String name,String filepath,String lname,String tname,String treatmentname,String amountforTreatment) throws InterruptedException,StaleElementReferenceException {
		 List<WebElement> appointmentDetails = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-appointments/div/div[2]/div[2]/mwl-calendar-month-view/div/div/div/div/mwl-calendar-month-cell"));
		
		// Thread.sleep(5000);
			for (int i = 0; i < appointmentDetails.size() - 1; i++) {
				
				try {
				 details = appointmentDetails.get(i).getText();
				}
				catch(StaleElementReferenceException s)
				{
					List<WebElement>appointmentDetails1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-appointments/div/div[2]/div[2]/mwl-calendar-month-view/div/div/div/div/mwl-calendar-month-cell"));
					Iterator<WebElement> iterator = appointmentDetails1.iterator();

					while (iterator.hasNext()) {
						 details = appointmentDetails1.get(i).getText();
				     }
				
				}
				try {
				if(details.contains(date)) {
					appointmentDetails.get(i).click();
					}
				}
				catch(StaleElementReferenceException s)
				{
					List<WebElement>appointmentDetails1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-appointments/div/div[2]/div[2]/mwl-calendar-month-view/div/div/div/div/mwl-calendar-month-cell"));
					Iterator<WebElement> iterator = appointmentDetails1.iterator();

					while (iterator.hasNext()) {
						 details = appointmentDetails1.get(i).getText();
				     }
					if(details.contains(date))
						{while (iterator.hasNext()) {
							appointmentDetails1.get(i).click();}
						}
					}
				
					 List<WebElement> appList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-appointments/div/div[2]/div[2]/div/div[3]/div/a/div[1]/a"));
					 for (int j = 0; j <= appList.size() - 1; j++) {
							String details1 = appList.get(j).getText();
							//System.out.println(name);
							//if(details1.contains(name)) {
								System.out.println("#"+details1);
								Thread.sleep(5000);
								//WebElement view=driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-appointments/div/div[2]/div[2]/div/div["+(j+1)+"]/div/div/div/div"));
								view.click();
								Thread.sleep(5000);
								//toBookAppointments(name);
								//Thread.sleep(3000);
								viewPaymentDetails();
								Thread.sleep(3000);
								viewMedication();
								Thread.sleep(3000);
								uploadPrescription(filepath);
								toAddTestLabs(lname, tname);
								toAddTreatment(treatmentname, amountforTreatment);
								break;
								//}
					 }
					 
			}			
	}
		 
	public void viewPaymentDetails() throws InterruptedException
	{
		
		Thread.sleep(3000);
		paymentDetails.click();
		List<WebElement> paymentList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-appointment-details/div[1]/div[2]/div/div[2]/div/a"));
		//System.out.print("*"+paymentList.get(0).getText());
		 for (int j = 0; j < paymentList.size() - 1; j++) {
				String details1 = paymentList.get(j).getText();
				System.out.println("@"+details1);
		
	}
	}
	public void viewMedication() throws InterruptedException
	{
		Thread.sleep(3000);
		medication.click();
		System.out.println("Medication");
	}
	public void uploadPrescription(String filepath) throws InterruptedException
	{
		
		Thread.sleep(5000);
		uploadPrescription.click();
		Thread.sleep(2000);
		System.out.println("Prescription");
	
		choosefile.sendKeys(filepath);
		Thread.sleep(3000);
		upload.click();
		
		
		
	}
	public void toBookAppointments(String name)
	{
		List<WebElement> patientnameList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-appointments/div/div[2]/div[2]/div/div"));
		
		 for (int j = 0; j < patientnameList.size() - 1; j++) {
				String details1 = patientnameList.get(j).getText();
				
				if(details1.contains(name)) {
					
					patientnameList.get(j).click();
					
					
					
	}
	
	}
	}
	public void toAddTestLabs(String lname,String tname) throws InterruptedException
	{
		
		testLabs.click();
		Thread.sleep(3000);
		addTestLab.click();
		Thread.sleep(3000);
		labName.sendKeys(lname);
		addTests.click();	Thread.sleep(3000);
		testName.sendKeys(tname);	Thread.sleep(3000);
		addLabTests.click();	Thread.sleep(3000);
		
		
	}
	public void toAddTreatment(String treatname,String amountForTreatment) throws InterruptedException
	{
		treatment.click();
		Thread.sleep(3000);
		addNewTreatment.click();Thread.sleep(3000);
		treatmentName.sendKeys(treatname);Thread.sleep(3000);
		amount.sendKeys(amountForTreatment);Thread.sleep(3000);
		saveTreatment.click();Thread.sleep(3000);
	}
}
