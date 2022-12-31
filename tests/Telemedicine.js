module.exports = {
   
    
   
    'Test Case-3: Login as Doctor':async (browser)=>{
        var doctor='#doctor-tab'
        var emailID='/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div/div/div[2]/div/div[2]/div[2]/ng-form-generator/div/div/div/form/div/div[1]/div/div[1]/input';
        var password='/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div/div/div[2]/div/div[2]/div[2]/ng-form-generator/div/div/div/form/div/div[2]/div/div[1]/input';
        var loginBtn='/html/body/app-dashboard/div/main/div/app-login/div/main/div/div/div/div/div[2]/div/div[2]/div[2]/ng-form-generator/div/div/div/form/input';
        var users='body > app-dashboard > div > app-sidebar > app-sidebar-nav > app-sidebar-nav-items > app-sidebar-nav-link:nth-child(3) > a > app-sidebar-nav-link-content';
        var usersContainer='body > app-dashboard > div > main > div.container-fluid.mt-4 > app-users > div > div > div.card-body > div';
        browser.url('http://182.76.66.74/telemedicineRazorpay/auth/login/')
        .click(doctor) ;
        browser.useXpath();
      browser.setValue(emailID,'sheelak@deemsys.in');
      browser.setValue(password,'Telemedicine');
        browser.click(loginBtn);
        browser.pause(3000);
       // browser.url('http://182.76.66.74/telemedicineRazorpay/doctor/dashboard');
       
        browser.click('/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[3]/a');
        userValue=browser.getText('/html/body/app-dashboard/div/main/div[2]/app-users/div/div/div[2]/div');
        console.log(userValue);
        
    }
    

}