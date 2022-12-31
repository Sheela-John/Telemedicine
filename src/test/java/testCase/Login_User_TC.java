package testCase;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.Home_User;
import Pages.Login_User;
import Pages.MyAppointments;
import Pages.ProfileUser;

public class Login_User_TC  extends TestBase {
	Login_User login;
	Home_User homeuser;
	MyAppointments app;
	ProfileUser profile;
	public Login_User_TC() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		login=new Login_User();
		homeuser=new Home_User();
		app=new MyAppointments();
		profile=new ProfileUser();
	}
	@Test
	public void loginTest() throws IOException, InterruptedException {
		homeuser=login.login(prop.getProperty("useremail"), prop.getProperty("userpassword"));
		Thread.sleep(4000);
		System.out.println("Logged In");
	}
	@Test
	public void homeTest()throws InterruptedException
	{
		homeuser=login.login(prop.getProperty("useremail"), prop.getProperty("userpassword"));
		Thread.sleep(4000);
		homeuser.view();
		//homeuser.viewSearchProviders();
		//homeuser.searchProvider("shinoj");
		homeuser.toBookAppointment("Jenifer","Online","12/23/2022","12:00 - 12:30","headache");
	}
	@Test
	public void myAppointmentsTest() throws  InterruptedException
	{
		homeuser=login.login(prop.getProperty("useremail"), prop.getProperty("userpassword"));
		Thread.sleep(4000);
		app.view();
		app.viewAppointmentDetails("Upcoming Appointments");
	}
	@Test    
	public void profileTest() throws InterruptedException
	{
		homeuser=login.login(prop.getProperty("useremail"), prop.getProperty("userpassword"));
		Thread.sleep(4000);
		profile.view();
		profile.editProfile("Rahul","Male","5","8","70","05-10-1994","B-","Coimbatore","Dola","Paracetamol","Heart","nill","nill","shell fish allergy","sugar patient diet","No",	"No","Little to no exercise");
	}
}