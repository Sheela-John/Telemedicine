package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class Login_Admin extends TestBase {
	@FindBy(xpath = "//*[@id=\"user-tab\"]")
	WebElement user_tab;

	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div/div/div[2]/div/div[2]/div[1]/ng-form-generator/div/div/div/form/div/div[1]/div/div[1]/input")
	WebElement email;
	@FindBy(xpath = "/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div/div/div[2]/div/div[2]/div[1]/ng-form-generator/div/div/div/form/div/div[2]/div/div[1]/input")
	WebElement password;

	@FindBy(xpath="/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div/div/div[2]/div/div[2]/div[1]/ng-form-generator/div/div/div/form/input")
	WebElement login_btn;

	public Login_Admin() {
		PageFactory.initElements(driver, this);
	}

	public  Home_Admin login(String emailval, String pwd) throws InterruptedException {
		user_tab.click();
		Thread.sleep(3000);
		email.sendKeys(emailval);
		Thread.sleep(3000);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		login_btn.click();
		Thread.sleep(5000);
		return new Home_Admin();
	}
}