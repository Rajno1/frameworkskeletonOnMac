package com.issi.pageFactory;

import com.issi.Base.BaseClass;
import com.issi.constants.FrameworkConstants;
import com.issi.utilities.ExcelUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BaseClass {
    public HomePage(WebDriver driver) {
        excel = new ExcelUtilities(FrameworkConstants.getExcelTestDataPath());
        PageFactory.initElements(driver,this);
    }
    @FindBy(how = How.XPATH,using = "//a[@href='#']//span[contains(text(),'Customers')]")
    WebElement CustomersMenu;

    @FindBy(how = How.XPATH,using ="//a[@href='/Admin/Customer/List']//span[contains(text(),'Customers')]")
    WebElement customerMenuItem;

    @FindBy(how = How.XPATH,using ="//a[@class='btn bg-blue']")
    WebElement addButton;

    @FindBy(how= How.XPATH, using ="//input[@name='Email']")
    WebElement Email_text;

    @FindBy(how=How.XPATH,using ="//input[@id='Password']")
    WebElement Password_text;

    @FindBy(how= How.XPATH,using ="//input[@id='FirstName']")
    WebElement FirstName_text;

    @FindBy(how= How.XPATH,using ="//input[@name='LastName']")
    WebElement LastName_text;

    @FindBy(how= How.XPATH,using ="//input[@id='Gender_Male']")
    WebElement Gender_male;

    @FindBy(how= How.XPATH,using ="//input[@id='Gender_Female']")
    WebElement Gender_female;

    @FindBy(how= How.XPATH,using ="//input[@name='DateOfBirth']")
    WebElement DOB_date;

    @FindBy(how= How.XPATH,using ="//input[@id='Company']")
    WebElement Company_name_text;

    @FindBy(how= How.XPATH,using ="//input[@name='IsTaxExempt']")
    WebElement is_tax_empty_chbox;

    @FindBy(how= How.XPATH,using ="(//div[@class='k-multiselect-wrap k-floatwrap' and @role='listbox'])[1]")
    WebElement Newsletter_chbox;

    @FindBy(how= How.XPATH,using ="//li[contains(text(),'Test store 2')]")
    WebElement Test_store2_chbox;

    @FindBy(how= How.XPATH,using ="//div[@class='k-multiselect-wrap k-floatwrap']")
    WebElement Customer_role_drpdn;


    By AlreadySelected_custrole = By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[contains(text(),'Registered')]");
    By Administrators_option = By.xpath("//li[contains(text(),'Administrators')]");
    By ForumModerators_option  = By.xpath("//li[contains(text(),'Forum Moderators')]");
    By Guest_option = By.xpath("//li[contains(text(),'Guests')]");
    By Vendors_option = By.xpath("//li[contains(text(),'Vendors')]");

    @FindBy(how=How.XPATH,using="//select[@name='VendorId']")
    WebElement Manager_of_vendor;

    By Vendor_1 = By.xpath("//option[contains(text(),'Vendor 1')]");
    By Vendor_2 = By.xpath("//option[contains(text(),'Vendor 2')]");

    @FindBy(how=How.XPATH,using="//input[@name='Active']")
    WebElement Active_chbox;

    @FindBy(how=How.XPATH,using="//textarea[@id='AdminComment']")
    WebElement Admin_comment;

    @FindBy(how=How.XPATH, using ="//button[@name='save']")
    WebElement save_button;

    //Elements of Delete Customer

    //action methods

    public void clickCustomersMenu()  {

        clickOn(CustomersMenu);
    }

    public void clickCustomerMenuItem() {
        clickOn(customerMenuItem);
    }

    public void clickOnAddbutton() {
        clickOn(addButton);
    }

    public void Enter_email(String string) {
        enterText(Email_text, string);
    }

    public void Enter_password(String string) {
        enterText(Password_text, string);
    }

    public void Enter_Frist_Name(String string) {
        enterText(FirstName_text, string);
    }

    public void Enter_Last_Name(String string) {
        enterText(LastName_text, string);
    }

    public void select_gender(String gender) {
        if(gender.equalsIgnoreCase("Male"))
            clickOn(Gender_male);
        else if(gender.equalsIgnoreCase("Female"))
            clickOn(Gender_female);
    }

    public void Enter_DOB(String date) {
        enterText(DOB_date, date);
    }

    public void Enter_company_name(String compname) {
        enterText(Company_name_text, compname);
    }

    public void clickOn_is_taxempty() {
        clickOn(is_tax_empty_chbox);
    }

    public void cickOn_Newsletter() {
        clickOn(Newsletter_chbox);
        clickOn(Test_store2_chbox);
    }

    public void select_customerRole(String role) {
        WebElement role_option = null;
        if(!role.equals("Vendors")) {
            getElement(driver, AlreadySelected_custrole);

        }

        clickOn(Customer_role_drpdn);

        if(role.equals("Administrators")) {
            role_option = getElement(driver, Administrators_option);
        }
        else if(role.equals("Forum Moderators")){
            role_option = getElement(driver,ForumModerators_option );
        }
        else if(role.equals("Guests")) {
            role_option = getElement(driver, Guest_option);
        }

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", role_option);
    }


    public void select_vendor(String vendorID) {
        Select vendor = new Select(Manager_of_vendor);

        if(vendorID.equals("Vendor 1")) {
            vendor.selectByVisibleText("Vendor 1");
        }
        else if(vendorID.equals("Vendor 2")) {
            vendor.selectByVisibleText("Vendor 2");
        }


    }

    public void activeChbx_status() {
        boolean status = Active_chbox.isSelected();
        System.out.println("Active staus is" + status);
    }

    public void AddAdmin_comments(String string) {
        enterText(Admin_comment, string);
    }

    public void click_save() {
        clickOn(save_button);
    }


}
