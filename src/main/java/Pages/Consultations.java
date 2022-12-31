package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class Consultations extends TestBase{
	String details="";
	Appointments appointments=new Appointments();
	
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[5]/a")
	WebElement consultations;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-consultations/div/div[2]/div[1]/div[2]/input")
	WebElement date;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/nav/div/a[1]")
	WebElement consultationDetails;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[1]/a")
	WebElement back;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/nav/div/a[2]")
	WebElement prescriptionFiles;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/nav/div/a[3]")
	WebElement prescription;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/nav/div/a[4]")
	WebElement medication;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/div/div[4]/div/div/div/div/form/div[1]/input")
	WebElement pharmacyName;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/div/div[4]/div/div/div/div/form/button")
	WebElement addMed;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/div/div[4]/div/div/div/div/form/div[2]/div/div[1]/div/input")
	WebElement medName;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/div/div[4]/div/div/div/div/form/div[2]/div/div[2]/div[3]/div/div/input")
	WebElement phase;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/div/div[4]/div/div/div/div/form/div[2]/div/div[3]/div[2]/button")
	WebElement addSession;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/div/div[4]/div/div/div/div/form/div[2]/div/div[4]/div/div/div[2]/div/input")
	WebElement inTakeValue;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/div/div[4]/div/div/div/div/form/div[2]/div/div[5]/div/div/textarea")
	WebElement notes;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/div/div[4]/div/div/div/div/div/button")
	WebElement savePharmacy;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/div/div[4]/div/div/div/div/form/button")
	WebElement addMedicine;
	
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
	 public Consultations() {
		PageFactory.initElements(driver, this);
	}
	public void viewConsultations()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[5]/a")));
		consultations.click();
	}
	public void setDateValue(String dateval) throws InterruptedException
	{
		date.clear();
		date.sendKeys(dateval);
		System.out.println(dateval);
	}
	public void setStatus(String status)
	{
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-consultations/div/div[2]/div[1]/div[4]/select")));
		select.selectByVisibleText(status);
		System.out.println("Selected");
	}
	public void viewConsultationsDetails(String date,String status,String pname,String mname,String medType,String inTakeTime,String phaseType,String phaseNumber,String session,String InTakeType,String inTakeVal,String notesVal,String TestLabName,String TestName,String Treatment,String amount) throws InterruptedException
	{
		setDateValue(date);
		setStatus(status);
		Thread.sleep(3000);
		 List<WebElement> consultList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-consultations/div/div[2]/div[2]/div"));
			for (int i = 0; i < consultList.size() - 1; i++) {
				try {
				 details = consultList.get(i).getText();
				System.out.println(details);
				consultList.get(i).click();
				prescriptionDetails();
				addMedication(pname, mname, medType, inTakeTime, phaseType, phaseNumber, session, InTakeType, inTakeVal, notesVal);
				}
				catch(StaleElementReferenceException s)
				{
					 List<WebElement> consultList1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-consultations/div/div[2]/div[2]/div"));
					Iterator<WebElement> iterator = consultList1.iterator();

					while (iterator.hasNext()) {
						 details = consultList1.get(i).getText();	
						 consultList1.get(i).click();
				     }
					
					prescriptionDetails();
					addMedication(pname, mname, medType, inTakeTime, phaseType, phaseNumber, session, InTakeType, inTakeVal, notesVal);
					System.out.println("AddTestLab");
					toAddTestLabs(TestLabName,TestName);
					toAddTreatment(Treatment, amount);
				}
				break;
				
			}
		 
	}
	public void prescriptionDetails() throws InterruptedException
	{
		Thread.sleep(5000);
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/nav/div/a[2]")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/nav/div/a[2]")));
		  }
		//prescriptionFiles.click();
		Thread.sleep(3000);
		List<WebElement> prescriptionList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/div/div"));
		for (int i = 0; i < prescriptionList.size() - 1; i++) {
			String pres = prescriptionList.get(i).getText();
			System.out.println(pres);
			
			
		}
			
	}
	public void addMedication(String pname,String mname,String medType,String inTakeTime,String phaseType,String phaseNumber,String session,String InTakeType,String inTakeVal,String notesVal) throws InterruptedException
	{
		Thread.sleep(3000);
		///prescription.click();
		medication.click();
		Thread.sleep(3000);
		pharmacyName.sendKeys(pname);
		addMed.click();
		medName.sendKeys(mname);
		Select selectMedType = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/div/div[4]/div/div/div/div/form/div[2]/div/div[2]/div[1]/div/select")));
		selectMedType.selectByVisibleText(medType);
		Select selectinTakeTime = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/div/div[4]/div/div/div/div/form/div[2]/div/div[2]/div[2]/div/select")));
		selectinTakeTime.selectByVisibleText(inTakeTime);
		Select selectphaseType = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/div/div[4]/div/div/div/div/form/div[2]/div/div[2]/div[3]/div/div/div/select")));
		selectphaseType.selectByVisibleText(phaseType);
		
		phase.sendKeys(phaseNumber);
		addSession.click();
		Select selectSession = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/div/div[4]/div/div/div/div/form/div[2]/div/div[4]/div/div/div[1]/select")));
		selectSession.selectByVisibleText(session);
		Select selectInTakeType = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-view-consultation/div[1]/div[2]/div/div[4]/div/div/div/div/form/div[2]/div/div[4]/div/div/div[2]/div/div/select")));
		selectInTakeType.selectByVisibleText(InTakeType);
		inTakeValue.sendKeys(inTakeVal);
		notes.sendKeys(notesVal);
		Thread.sleep(3000);
		savePharmacy.click();
		//addMedicine.click();
		Thread.sleep(3000);
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
