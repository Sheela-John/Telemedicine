package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import Base.TestBase;
import io.opentelemetry.api.internal.StringUtils;

public class Medications extends TestBase {
	
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[8]/a")
	WebElement medications;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-my-medications/div[1]/div/div[1]/a")
	WebElement addMedic;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-my-medications/div[3]/div/div/div[2]/form/div/div/div[1]/input")
	WebElement medicName;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-my-medications/div[3]/div/div/div[3]/button[1]")
	WebElement addMedicBtn;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-my-medications/div[1]/div/div[2]/div[1]/div/input")
	WebElement search_medic;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-my-medications/div[1]/div/div[2]/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/span[1]")
	WebElement edit;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-my-medications/div[1]/div/div[2]/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/span[2]")
	WebElement delete;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-my-medications/div[2]/div/div/div[3]/button[1]")
	WebElement deletesure;
	public Medications()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void viewMedications() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[8]/a")));
		medications.click();
		Thread.sleep(3000);
	}
	public void AddMedic(String medicationName,String medicType) throws InterruptedException
	{
		addMedic.click();
		Thread.sleep(3000);
		medicName.sendKeys(medicationName);
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-my-medications/div[3]/div/div/div[2]/form/div/div/div[3]/select")));
		select.selectByVisibleText(medicType);
		addMedicBtn.click();
		Thread.sleep(5000);
	}
	public WebElement searchMedications(String medic) throws InterruptedException
	{
		Thread.sleep(3000);
		search_medic.sendKeys(medic+Keys.ENTER);
		 List<WebElement> SearchMedicList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-my-medications/div[1]/div/div[2]/div[2]/div"));
			for (int j = 0; j <= SearchMedicList.size() - 1; j++) {	
				String details =SearchMedicList.get(j).getText();
				 if (details.contains(medic))
				 {
						System.out.println("Medication:"+details);
						Thread.sleep(7000);
						return SearchMedicList.get(j);
				}
		}
			return null;
			
		
	}
	public static String removeLastChar(String str) {
	    return removeLastChars(str, 1);
	}

	public static String removeLastChars(String str, int chars) {
	    return str.substring(0, str.length() - chars);
	}
	public void toEditMedication(String medic,String newMedic,String newType) throws InterruptedException
	{
		WebElement val= searchMedications(medic);
		String temp=val.toString().split(":")[2].trim();
		String temp1=removeLastChar(temp);
		Actions action = new Actions(driver);
		WebElement med = driver.findElement(By.xpath(""+temp1+""));
		action.moveToElement(med).click().perform();
		edit.click();
		Thread.sleep(4000);
		medicName.clear();
		medicName.sendKeys(newMedic);
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-my-medications/div[3]/div/div/div[2]/form/div/div/div[3]/select")));
		select.selectByVisibleText(newType);
		addMedicBtn.click();
		Thread.sleep(5000);
	}
	public void toDeleteMedication(String medic)throws InterruptedException
	{
		WebElement val= searchMedications(medic);
		
		String temp=val.toString().split(":")[2].trim();
		String temp1=removeLastChar(temp);
		Actions action = new Actions(driver);
		WebElement med = driver.findElement(By.xpath(""+temp1+""));
		action.moveToElement(med).click().perform();
		delete.click();
		Thread.sleep(3000);
		deletesure.click();
	}
}
