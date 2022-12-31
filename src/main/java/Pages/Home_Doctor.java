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

public class Home_Doctor extends TestBase {
	
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[3]/a")
	WebElement Users;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div[2]/app-users/div/div/div[2]/div")
	WebElement UsersContainer;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-users/div/div[2]/div/div[2]/div/div/nav/div/a[1]")
	WebElement medicalHistory;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-users/div/div[2]/div/div[2]/div/div/nav/div/a[2]")
	WebElement lifestyle;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div[2]/app-view-users/div/div[2]/div/div[2]/div/div/nav/div/a[3]")
	WebElement appointments;
	

	public Home_Doctor() {
		PageFactory.initElements(driver, this);
	}

	public void clickUsers() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[3]/a")));
		Users.click();

	}

	public void viewUsers(String uName) throws InterruptedException {
		List<WebElement> usersList = driver.findElements(By.xpath("//div[@class='card-body row pb-0 pt-3']"));
		System.out.println(usersList.size());
		for (int i = 0; i <= usersList.size() - 1; i++) {
			String userListName = usersList.get(i).getText();
			 if (userListName.contains(uName)) {
				 	Thread.sleep(4000);
					usersList.get(i).click();
					Thread.sleep(3000);
					System.out.println("userName"+userListName);
					break;
				}
		}
	}
	public void viewPersonnalDetails()
	 {
		System.out.println("PersonnalDetails");
		List<WebElement> elements = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-view-users/div/div[2]/div/div[1]/div/table"));

		for(WebElement element: elements)
		{
		       System.out.println(element.getText());
		}
	 }
 public void viewMedicalHistory()
 {
	 medicalHistory.click();
	 List<WebElement> medHistory = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-view-users/div/div[2]/div/div[2]/div/div/div"));
		System.out.println(medHistory.size());
		for (int i = 0; i <= medHistory.size() - 1; i++) {
			String history = medHistory.get(i).getText();
			System.out.println(history);
		}
	 
 }
	
public void viewLifestyle()
{
lifestyle.click();
List<WebElement> lifestyleList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-view-users/div/div[2]/div/div[2]/div/div/div/div[2]"));
	System.out.println(lifestyleList.size());
	for (int i = 0; i <= lifestyleList.size() - 1; i++) {
		String lifeStyleContent = lifestyleList.get(i).getText();
		System.out.println(lifeStyleContent);
	}

}
public void viewAppointments()
{
appointments.click();
List<WebElement> appointmentList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div[2]/app-view-users/div/div[2]/div/div[2]/div/div/div"));
	System.out.println(appointmentList.size());
	for (int i = 0; i <= appointmentList.size() - 1; i++) {
		String appointmentsContent = appointmentList.get(i).getText();
		System.out.println(appointmentsContent);
	}

}
		
		
	

}
