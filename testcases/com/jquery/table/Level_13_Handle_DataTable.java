package com.jquery.table;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_13_Handle_DataTable extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	List<String> allValueUI = new ArrayList<String>();
	List<String> allValueDB= new ArrayList<String>();
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage= PageGeneratorManager.getHomePage(driver);
	}

	//@Test
	public void TC_01_() {
		// Search dữ liệu trong 1 table (trong header)
		homePage.inputToColumnTextboxByName("Females", "384187");
		homePage.sleepInSecond(2);
		
		homePage.inputToColumnTextboxByName("Males", "407124");
		homePage.sleepInSecond(2);
		
		homePage.inputToColumnTextboxByName("Country", "Afghanistan");
		homePage.sleepInSecond(2);

		homePage.inputToColumnTextboxByName("Total", "791312");
		homePage.sleepInSecond(2);

	}
	
	//@Test
	public void TC_02_Paging() {
		// Click to any page
		homePage.clickToPageLinkByNumber("10");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("10"));
		
		homePage.clickToPageLinkByNumber("12");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("12"));
		
		homePage.clickToPageLinkByNumber("17");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("17"));
		
		homePage.clickToPageLinkByNumber("19");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("19"));
	} 
	
	//@Test
	public void TC_03_Displayed() {
		// Verify for any row
		Assert.assertTrue(homePage.isRowValueDisplayed("24128", "Albania", "25266", "49397"));
		
		Assert.assertTrue(homePage.isRowValueDisplayed("276880", "Angola", "276472", "553353"));

	}
	
	//@Test
	public void TC_04_Icon_Button_Checkbox() {
		// Click vào Icon_Button_Checkbox của row bất kì
		// Tìm đc key là duy nhất của row đó - ko trùng với các row khác
		homePage.clickToRowActionByCountryName("Afghanistan", "remove");
		homePage.refreshCurrentPage(driver);
		homePage.clickToRowActionByCountryName("Albania", "edit");
		homePage.refreshCurrentPage(driver);
		homePage.clickToRowActionByCountryName("Afghanistan", "edit");
		homePage.refreshCurrentPage(driver);

	}
	//@Test
	public void TC_05_Get_All_Column_Values() {
		//UI
		allValueUI= homePage.getAllPageValuesByColumnName("Country");
		
		//DB
		//allValueDB = homePage.getAllPageValuesByColumnNameInDB("Country");
		
		//API
		//allValueDB = homePage.getAllPageValuesByColumnNameInAPI("Country");
		
		//Assert.assertEquals(allValueUI, allValueDB);
		
		homePage.getAllPageValuesByColumnName("Total");
			
	}
	
	@Test
	public void TC_06_Action_By_Index() {
		homePage.openUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
		// Nhập vào textBox cột contact person dòng thứ 2
		homePage.enterToTextBoxByColumnNameAndRowIndex("Contact Person", "2", "ABC");
		homePage.enterToTextBoxByColumnNameAndRowIndex("Company", "3", "Company");
		
		// Select dữ liệu tại cột Country dòng thứ 3
		homePage.selectToDropdownListByColumnNameAndRowIndex("Country", "2", "Hong Kong");

		// Click vào checkbox tại cột NPO? dòng thứ 1
		homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "2");
		homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "3");
	}
	
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}



}
