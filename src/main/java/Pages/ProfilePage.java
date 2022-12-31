package Pages;

import java.awt.RenderingHints.Key;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class ProfilePage extends TestBase {
	
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")
	WebElement profile;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-doctor-profile/div[2]/div[2]/form/div/div[3]/div[1]/div[1]/input")
	WebElement fullName;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-doctor-profile/div[2]/div[2]/form/div/div[3]/div[2]/div[1]/input")
	WebElement speciality;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-doctor-profile/div[2]/div[2]/form/div/div[3]/div[1]/div[3]/input")
	WebElement age;
	@FindBy (xpath="/html/body/app-dashboard/div/main/div[2]/app-doctor-profile/div[2]/div[2]/form/div/div[3]/div[2]/div[3]/div/div/textarea")
	WebElement workingHours;
	@FindBy(xpath="//*[@id=\"GenderRadio1\"]")
	WebElement male;
	@FindBy(xpath="//*[@id=\"GenderRadio2\"]")
	WebElement female;
	@FindBy(xpath="//*[@id=\"GenderRadio3\"]")
	WebElement other;
	@FindBy(xpath="//*[@id=\"inputCity\"]")
	WebElement location;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-doctor-profile/div[2]/div[2]/form/div/div[3]/div[2]/div[5]/div/input")
	WebElement fees;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-doctor-profile/div[2]/div[2]/form/div/div[3]/div[1]/div[9]/div/input")
	WebElement experience;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-doctor-profile/div[2]/div[2]/form/div/div[3]/div[2]/div[7]/input")
	WebElement phNum;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-doctor-profile/div[2]/div[2]/form/div/div[3]/div[2]/div[9]/div[1]/ng-multiselect-dropdown/div/div[1]/span")
	WebElement selectClinic;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-doctor-profile/div[2]/div[2]/div/div/div/button")
	WebElement updatePorfileBtn;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-doctor-profile/div[2]/div[2]/form/div/div[3]/div[2]/div[9]/div[3]/button/i")
	WebElement addClinicBtn;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-doctor-profile/div[3]/div/div/div[2]/form/div[1]/div[1]/div/input")
	WebElement addclinicName;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-doctor-profile/div[3]/div/div/div[2]/form/div[2]/div[1]/div/input")
	WebElement addAddress;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-doctor-profile/div[3]/div/div/div[2]/div/div/div/button[2]")
	WebElement saveBtn;
	
	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}
	public void viewProfile()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")));
		profile.click();
	}
	public void EditProfile(String fname,String special, String tage,String wHours,String gender,String loc,String fee,String exp,String pNumber,String clinicName) throws InterruptedException
	{
		fullName.clear();
		Thread.sleep(4000);
		fullName.sendKeys(fname);
		speciality.clear();
		Thread.sleep(4000);
		speciality.sendKeys(special);
		age.clear();
		Thread.sleep(3000);
		age.sendKeys(tage);
		workingHours.clear();
		Thread.sleep(3000);
		workingHours.sendKeys(wHours);
		Thread.sleep(4000);
		if(gender.equals("Male"))
		{
			try {
			     driver.findElement(By.linkText("Scans")).click();
			  } catch (Exception e) {
			     JavascriptExecutor executor = (JavascriptExecutor) driver;
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-doctor-profile/div[2]/div[2]/form/div/div[3]/div[1]/div[5]/div/div[1]/input")));
			  }
		}
		else if(gender.equals("Female"))
		{
			try {
			     driver.findElement(By.linkText("Scans")).click();
			  } catch (Exception e) {
			     JavascriptExecutor executor = (JavascriptExecutor) driver;
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-doctor-profile/div[2]/div[2]/form/div/div[3]/div[1]/div[5]/div/div[2]/input")));
			  }
			//female.click();
		}
		else if(gender.equals("other"))
		{
			try {
			     driver.findElement(By.linkText("Scans")).click();
			  } catch (Exception e) {
			     JavascriptExecutor executor = (JavascriptExecutor) driver;
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-doctor-profile/div[2]/div[2]/form/div/div[3]/div[1]/div[5]/div/div[3]/input")));
			  }
		}
		
		location.clear();
		Thread.sleep(4000);
		location.sendKeys(loc);
		fees.clear();
		Thread.sleep(4000);
		fees.sendKeys(fee);
		experience.clear();
		Thread.sleep(4000);
		experience.sendKeys(exp);
		phNum.clear();
		Thread.sleep(4000);
		phNum.sendKeys(pNumber);
		
		selectClinic.click();
		Thread.sleep(3000);
		 List<WebElement> SearchMedicList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-doctor-profile/div[2]/div[2]/form/div/div[3]/div[2]/div[9]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li"));
			for (int j = 0; j <= SearchMedicList.size() - 1; j++) {	
				String details =SearchMedicList.get(j).getText();
				
				 if (details.contains(clinicName))
				 {
						SearchMedicList.get(j).click();
						break;
						
				}
		}
		Thread.sleep(3000);
		updatePorfileBtn.click();
		Thread.sleep(3000);
		
	}
	public void addClinic(String cname,String address) throws InterruptedException
	{
		Thread.sleep(3000);
		addClinicBtn.click();
		Thread.sleep(4000);
		addclinicName.sendKeys(cname);
		Thread.sleep(3000);
		addAddress.sendKeys(address);
		Thread.sleep(3000);
		saveBtn.click();
	}
	
}
