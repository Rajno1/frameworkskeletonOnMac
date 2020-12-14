package com.issi.tests;

import com.issi.Base.BaseClass;
import com.issi.pageFactory.LoginPage;
import org.testng.annotations.Test;

import static com.issi.pageFactory.LoginPage.*;


public class LoginPageTest extends BaseClass {

    @Test
    public void login_Functionality(){
        logpg = new LoginPage(driver);
        enterEmailId();
      //  test.info("user name "+"admin"+" has been entered");
        enterPassword();
        //test.info("password "+"manager"+" has been entered");
        clickOnLoginbtn();
       // test.info("clicked on login button");
    }

}
