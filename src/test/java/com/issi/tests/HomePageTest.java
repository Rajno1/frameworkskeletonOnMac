package com.issi.tests;

import com.issi.Base.BaseClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
    @Test
    public void homePageTest(){
        pageTitleValidation(driver,"Dashboard / nopCommerce administration");
        test.info("Home page title has been validated successfully");

    }

}
