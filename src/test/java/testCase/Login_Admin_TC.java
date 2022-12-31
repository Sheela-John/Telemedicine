package testCase;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.Admin_Create_Doctor;
import Pages.Admin_Users;
import Pages.Home_Admin;
import Pages.Home_User;
import Pages.Login_Admin;
import Pages.Login_User;
import Pages.MyAppointments;
import Pages.ProfileUser;

public class Login_Admin_TC  extends TestBase {
	Login_Admin login;
	Home_Admin homeadmin;
	Admin_Create_Doctor addDoctor;
	Admin_Users users;
	
	public Login_Admin_TC() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		login=new Login_Admin();
		homeadmin=new Home_Admin();
		addDoctor=new Admin_Create_Doctor();
		users=new Admin_Users();
	}
	@Test
	public void loginTest() throws IOException, InterruptedException {
		homeadmin=login.login("admin@telemedicine.com","admin@123");
		Thread.sleep(4000);
		System.out.println("Logged In");
	}
	@Test
	public void viewDoctorsTest() throws InterruptedException{
		homeadmin=login.login("admin@telemedicine.com","admin@123");
		Thread.sleep(4000);
		homeadmin.view();
		//homeadmin.viewDoctorsList("Show All");
		homeadmin.searchDoctor("K");
	}
	@Test
	public void AddDoctorTest() throws InterruptedException{
		homeadmin=login.login("admin@telemedicine.com","admin@123");
		Thread.sleep(4000);
		addDoctor.view();
		Thread.sleep(2000);
		addDoctor.addDoctor("Tiana5","Tiana5@gmail.com","1974567890","Tiana@123");
	}
	@Test
	public void UsersTest() throws InterruptedException{
		homeadmin=login.login("admin@telemedicine.com","admin@123");
		Thread.sleep(4000);
		users.view();
		//users.viewUsersList("Show All");
		users.searchuser("Rahul");
	}

}
