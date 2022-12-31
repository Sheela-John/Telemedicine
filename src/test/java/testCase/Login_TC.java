package testCase;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import Base.TestBase;
import Pages.Appointments;
import Pages.Consultations;
import Pages.Home_Doctor;
import Pages.Login;
import Pages.Medications;

import Pages.ProfilePage;
import Pages.Reports;
import Pages.UploadPriscription;
import Pages.WorkingHours;

public class Login_TC extends TestBase {
		Login loginPage;
		Home_Doctor homedoctor;
		Appointments app;
		Consultations consult;
		WorkingHours wHours;
		Reports rep;
		Medications medic;
		ProfilePage profile;
		UploadPriscription prescription;
		
		public Login_TC() {
			super();
		}

		@BeforeMethod
		public void setUp() {

			loginPage = new Login();
			homedoctor=new Home_Doctor();
			app=new Appointments();
			consult=new Consultations();
			wHours=new WorkingHours();
			rep=new Reports();
			medic=new Medications();
			profile=new ProfilePage();
			prescription=new UploadPriscription();
		}
		@Test
		public void loginTest() throws IOException, InterruptedException {
			homedoctor=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			Thread.sleep(4000);
			System.out.println("Logged In");
			homedoctor.clickUsers();
			homedoctor.viewUsers("Rahul");
			Thread.sleep(4000);
			homedoctor.viewPersonnalDetails();
			Thread.sleep(4000);
			homedoctor.viewMedicalHistory();
			Thread.sleep(4000);
			homedoctor.viewLifestyle();
			Thread.sleep(4000);
			homedoctor.viewAppointments();
		}
		@Test
		public void AppointmentTest() throws InterruptedException
		{
			homedoctor=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			Thread.sleep(3000);
			app.viewAppointments();
			Thread.sleep(3000);
			app.viewAllAppointments("23","raja","C:\\Users\\DSS-Test-1\\Desktop\\prescription.jpg","apollo","BloodTest","chemo","300000");
			Thread.sleep(3000);
		}
		
		@Test
		public void ConsultationsTest() throws InterruptedException
		{
			homedoctor=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			Thread.sleep(3000);
			consult.viewConsultations();
			
			consult.viewConsultationsDetails("15-12-2022","Completed","apollo","dolo","Tablet","After Meals","Days","3","Night","tablet","1","Take medicine on time","green Pharmacy","bloodTest","Chemo","3000");
		}
		@Test
		public void WorkingHoursTest() throws InterruptedException 
		{
			homedoctor=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			Thread.sleep(3000);
			wHours.viewWorkingHours();
			Thread.sleep(3000);
			wHours.SetDayValue("Monday");
			Thread.sleep(5000);
			wHours.toEnabletheDay("02:05", "05:00");
		}
		@Test
		public void ReportsTest() throws InterruptedException
		{
			homedoctor=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			Thread.sleep(3000);
			rep.viewReports();
			rep.selectDate("This Week","8","25");
		}
		@Test
		public void MedicationsTest()throws InterruptedException
		{
			homedoctor=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			Thread.sleep(3000);
			medic.viewMedications();
			medic.AddMedic("Citrezin","Tablet");
			//medic.searchMedications("Citrezin");
		//	medic.toEditMedication("Citrezin","amoxy","Syrup");Thread.sleep(5000);
			Thread.sleep(5000);
			medic.toDeleteMedication("Citrezin");
			Thread.sleep(5000);
			
		} 
		@Test
		public void ProfileTest() throws InterruptedException
		{
			homedoctor=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			profile.viewProfile();
			Thread.sleep(4000);
			//profile.EditProfile("Jenifer J","Pediatrist","25","Working Hours","Female","Chennai","450","4","1234567890","Glow Hospital");
			profile.addClinic("Tiana", "Chennai");
		}
		
		@Test
		public void uploadPrescriptionTest() throws InterruptedException
		{
				homedoctor=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
				prescription.viewAppointments();
				Thread.sleep(4000);
				prescription.uploadPrescription("C:\\Users\\DSS-Test-1\\Desktop\\prescription.jpg");
		}
		
	}